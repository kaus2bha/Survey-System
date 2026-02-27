package com.abis.survay_system.dto;

import java.util.List;

public class UserQuestionResponse {
    private Long id;
    private String text;
    private String type;
    private List<UserOptionResponse> options;

    public UserQuestionResponse(Long id, String text, String type, List<UserOptionResponse> options) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.options = options;
    }

    public Long getId() { return id; }
    public String getText() { return text; }
    public String getType() { return type; }
    public List<UserOptionResponse> getOptions() { return options; }
}