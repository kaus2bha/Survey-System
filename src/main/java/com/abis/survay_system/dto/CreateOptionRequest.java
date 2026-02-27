package com.abis.survay_system.dto;

public class CreateOptionRequest {

    private String text;
    private Boolean correct;   // add this

    public String getText() {
        return text;
    }

    public Boolean getCorrect() {
        return correct;
    }
}
