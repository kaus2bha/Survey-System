package com.abis.survay_system.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "options")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    @JsonIgnore
    private Question question;

    @Column(nullable = false)
    private String text;
    @Column(nullable = false)
    private Boolean correct = false;

    // ===== Getters =====

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public String getText() {
        return text;
    }

    public Boolean getCorrect() {
        return correct;
    }

    // ===== Setters =====

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
