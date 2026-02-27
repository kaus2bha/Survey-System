package com.abis.survay_system.service;

import com.abis.survay_system.dto.CreateOptionRequest;
import com.abis.survay_system.dto.OptionResponse;
import com.abis.survay_system.dto.QuestionResponse;
import com.abis.survay_system.model.Option;
import com.abis.survay_system.model.Question;
import com.abis.survay_system.model.QuestionType;
import com.abis.survay_system.model.Survey;
import com.abis.survay_system.repository.OptionRepository;
import com.abis.survay_system.repository.QuestionRepository;
import com.abis.survay_system.repository.SurveyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final SurveyRepository surveyRepository;
    private final OptionRepository optionRepository;

    public QuestionService(QuestionRepository questionRepository,
                           SurveyRepository surveyRepository,
                           OptionRepository optionRepository) {
        this.questionRepository = questionRepository;
        this.surveyRepository = surveyRepository;
        this.optionRepository = optionRepository;
    }

    public Question addQuestion(Long surveyId, Question question) {
        Survey survey = surveyRepository.findById(surveyId)
                .orElseThrow(() -> new RuntimeException("Survey not found"));

        question.setSurvey(survey);
        return questionRepository.save(question);
    }

    public List<QuestionResponse> getQuestionsBySurvey(Long surveyId) {
        return questionRepository.findBySurveyIdWithOptions(surveyId)
                .stream()
                .map(q -> new QuestionResponse(
                        q.getId(),
                        q.getText(),
                        q.getType().name(),
                        q.getOptions().stream()
                                .map(o -> new OptionResponse(o.getId(),
                                                             o.getText(),
                                                             o.getCorrect()))
                                .toList()
                ))
                .toList();
    }

    public OptionResponse addOption(Long questionId, CreateOptionRequest request) {

        Question question = questionRepository.findById(questionId)
                .orElseThrow(() -> new RuntimeException("Question not found"));

        Option option = new Option();
        option.setText(request.getText());

        // ✅ Default correct = false if client didn't send it
        if (request.getCorrect() == null) {
            option.setCorrect(false);
        } else {
            option.setCorrect(request.getCorrect());
        }

        option.setQuestion(question);

        Option saved = optionRepository.save(option);

        return new OptionResponse(
                saved.getId(),
                saved.getText(),
                saved.getCorrect()
        );
    }


}
