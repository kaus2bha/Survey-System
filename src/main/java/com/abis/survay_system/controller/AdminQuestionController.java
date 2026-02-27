package com.abis.survay_system.controller;

import com.abis.survay_system.dto.QuestionResponse;
import com.abis.survay_system.model.Question;
import com.abis.survay_system.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/surveys")
public class AdminQuestionController {

    private final QuestionService questionService;

    public AdminQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    // ✅ Add Question
    @PostMapping("/{surveyId}/questions")
    public Question addQuestion(@PathVariable Long surveyId,
                                @RequestBody Question question) {
        return questionService.addQuestion(surveyId, question);
    }

    // ✅ Get Questions
    @GetMapping("/{surveyId}/questions")
    public List<QuestionResponse> getQuestions(@PathVariable Long surveyId) {
        return questionService.getQuestionsBySurvey(surveyId);
    }
}
