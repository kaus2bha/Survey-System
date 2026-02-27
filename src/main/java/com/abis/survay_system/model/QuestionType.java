package com.abis.survay_system.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum QuestionType {
    MCQ,     // Multiple Choice Question
    TEXT,    // Free text answer
    RATING;   // 1–5 or 1–10 scale

    @Enumerated(EnumType.STRING)
    private QuestionType type;
}


