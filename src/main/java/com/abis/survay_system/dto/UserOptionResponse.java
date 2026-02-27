package com.abis.survay_system.dto;

public class UserOptionResponse {
    private Long id;
    private String text;

    public UserOptionResponse(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() { return id; }
    public String getText() { return text; }
}