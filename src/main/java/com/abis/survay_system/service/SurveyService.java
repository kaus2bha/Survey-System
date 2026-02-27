package com.abis.survay_system.service;

import com.abis.survay_system.dto.CreateSurveyRequest;
import com.abis.survay_system.model.Survey;
import com.abis.survay_system.repository.SurveyRepository;
import org.springframework.stereotype.Service;

@Service
public class SurveyService {

    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public Survey createSurvey(CreateSurveyRequest request) {
        Survey survey = new Survey();
        survey.setTitle(request.getTitle());
        survey.setDescription(request.getDescription());
        survey.setActive(true);

        return surveyRepository.save(survey);
    }
}
