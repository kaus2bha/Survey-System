package com.abis.survay_system.controller;

import com.abis.survay_system.dto.CreateOptionRequest;
import com.abis.survay_system.dto.OptionResponse;
import com.abis.survay_system.model.Option;
import com.abis.survay_system.service.QuestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
    @RestController
    @RequestMapping("/api/admin/questions")
    public class AdminOptionController {

        private final QuestionService questionService;

        public AdminOptionController(QuestionService questionService) {

            this.questionService = questionService;
        }

        @PostMapping("/{questionId}/options")
        public ResponseEntity<OptionResponse> addOption(
                @PathVariable Long questionId,
                @RequestBody CreateOptionRequest request) {

            OptionResponse saved = questionService.addOption(questionId, request);

            return ResponseEntity.ok(
                    new OptionResponse(saved.getId(), saved.getText(), saved.getCorrect())
            );
        }

    }


