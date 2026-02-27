package com.abis.survay_system.dto;

import com.abis.survay_system.dto.UserAnswerRequest;

import java.util.List;

public class SubmitSurveyRequest {

    private List<UserAnswerRequest> responses;

    public List<UserAnswerRequest> getResponses() {
        return responses;
    }

    public void setResponses(List<UserAnswerRequest> responses) {
        this.responses = responses;
    }
}