package com.abis.survay_system.dto;

import com.abis.survay_system.model.QuestionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateQuestionRequest {

    @NotBlank
    private String text;

    @NotNull
    private QuestionType type; // MCQ, TEXT, RATING

    // For MCQ only (can be empty for TEXT/RATING)
    private List<String> options;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public QuestionType getType() {
        return type;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}
