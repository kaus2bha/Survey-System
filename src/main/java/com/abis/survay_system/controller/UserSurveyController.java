package com.abis.survay_system.controller;

import com.abis.survay_system.dto.SubmitSurveyRequest;
import com.abis.survay_system.dto.SurveyResponse;
import com.abis.survay_system.service.UserSurveyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user/surveys")
public class UserSurveyController {

    private final UserSurveyService userSurveyService;

    public UserSurveyController(UserSurveyService userSurveyService) {
        this.userSurveyService = userSurveyService;
    }

    // ✅ GET /api/user/surveys/{id}
    @GetMapping("/{id}")
    public SurveyResponse getSurvey(@PathVariable Long id) {
        return userSurveyService.getSurveyById(id);
    }

    // ✅ POST /api/user/surveys/{id}/submit
    @PostMapping("/{id}/submit")
    public ResponseEntity<String> submitSurvey(@PathVariable Long id,
                                               @RequestBody SubmitSurveyRequest request) {
        userSurveyService.submitSurvey(id, request);
        return ResponseEntity.ok("Survey submitted successfully");
    }
}