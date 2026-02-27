package com.abis.survay_system.dto;

import java.util.List;

public class SurveyResponse {
    private Long id;
    private String title;
    private String description;
    private List<UserQuestionResponse> questions;

    public SurveyResponse(Long id, String title, String description, List<UserQuestionResponse> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public List<UserQuestionResponse> getQuestions() { return questions; }
}