package com.abis.survay_system.controller;

import com.abis.survay_system.dto.CreateSurveyRequest;
import com.abis.survay_system.model.Survey;
import com.abis.survay_system.service.SurveyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/surveys")
public class AdminSurveyController {

    private final SurveyService surveyService;

    public AdminSurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @PostMapping
    public ResponseEntity<Survey> createSurvey(@Valid @RequestBody CreateSurveyRequest request) {
        Survey survey = surveyService.createSurvey(request);
        return new ResponseEntity<>(survey, HttpStatus.CREATED);
    }
}
