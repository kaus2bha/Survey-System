package com.abis.survay_system.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import com.abis.survay_system.model.QuestionType;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id")
    @JsonBackReference
    private Survey survey;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Option> options = new ArrayList<>();
    public List<Option> getOptions() {
        return options;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }
    public Long getId() {
        return id;
    }


    public String getText() {
        return text;
    }

    public QuestionType getType() {
        return type;
    }

    public Survey getSurvey() {
        return survey;
    }
}
