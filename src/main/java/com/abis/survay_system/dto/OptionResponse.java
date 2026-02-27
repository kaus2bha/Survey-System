package com.abis.survay_system.dto;

public class OptionResponse {

    private Long id;
    private String text;
    private Boolean correct;

    public OptionResponse(Long id, String text, Boolean correct) {
        this.id = id;
        this.text = text;
        this.correct = correct;
    }

    public Long getId() { return id; }
    public String getText() { return text; }
    public Boolean getCorrect() { return correct; }
}

