package com.abis.survay_system.service;

import com.abis.survay_system.dto.SubmitSurveyRequest;
import com.abis.survay_system.dto.UserOptionResponse;
import com.abis.survay_system.dto.UserQuestionResponse;
import com.abis.survay_system.dto.SurveyResponse;
import com.abis.survay_system.model.*;
import com.abis.survay_system.repository.OptionRepository;
import com.abis.survay_system.repository.QuestionRepository;
import com.abis.survay_system.repository.SurveyRepository;
import com.abis.survay_system.repository.UserRepository;
import com.abis.survay_system.repository.ResponseRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

    private final ResponseRepository responseRepository;

    private final OptionRepository optionRepository;

    public UserSurveyService(SurveyRepository surveyRepository,
                             UserRepository userRepository,
                             QuestionRepository questionRepository,
                             OptionRepository optionRepository,
                             ResponseRepository responseRepository) {
        this.surveyRepository = surveyRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.responseRepository = responseRepository;
    }

    // ✅ GET /api/user/surveys/{id}
    public SurveyResponse getSurveyById(Long surveyId) {

        Survey survey = surveyRepository.findByIdWithQuestionsAndOptions(surveyId);

        if (survey == null) {
            throw new RuntimeException("Survey not found");
        }

        if (!survey.isActive()) {
            throw new RuntimeException("Survey is not active");
        }

        List<UserQuestionResponse> questions = survey.getQuestions()
                .stream()
                .map(q -> new UserQuestionResponse(
                        q.getId(),
                        q.getText(),
                        q.getType().name(),
                        q.getOptions()
                                .stream()
                                .map(o -> new UserOptionResponse(o.getId(), o.getText()))
                                .toList()
                ))
                .toList();

        return new SurveyResponse(
                survey.getId(),
                survey.getTitle(),
                survey.getDescription(),
                questions
        );
    }

    // ✅ POST /api/user/surveys/{id}/submit
    public void submitSurvey(Long surveyId, SubmitSurveyRequest request) {

        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey not found"));

        request.getResponses().forEach(answer -> {
            Question question = questionRepository.findById(answer.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            for (Long optionId : answer.getSelectedOptionIds()) {
                Option option = optionRepository.findById(optionId)
                        .orElseThrow(() -> new RuntimeException("Option not found"));

                UserResponse response = new UserResponse();
                response.setUser(user);          // IMPORTANT
                response.setSurvey(survey);
                response.setQuestion(question);
                response.setSelectedOption(option);

                responseRepository.save(response);  // 🔥 THIS WAS LIKELY MISSING
            }
        });
    }
}