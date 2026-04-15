package com.interviewforge.controller;

import com.interviewforge.dto.ApiResponse;
import com.interviewforge.model.Question;
import com.interviewforge.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public ResponseEntity<?> getQuestions(
            @RequestParam String domain,
            @RequestParam(required = false) String difficulty) {

        List<Question> questions;
        if (difficulty != null && !difficulty.isEmpty()) {
            questions = questionService.getQuestionsByDomainAndDifficulty(domain, difficulty);
        } else {
            questions = questionService.getQuestionsByDomain(domain);
        }

        return ResponseEntity.ok(new ApiResponse(true, "Questions retrieved", questions));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable Long id) {
        try {
            Question question = questionService.getQuestionById(id);
            return ResponseEntity.ok(new ApiResponse(true, "Question found", question));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/domains")
    public ResponseEntity<?> getDomains() {
        List<String> domains = questionService.getAllDomains();
        return ResponseEntity.ok(new ApiResponse(true, "Domains retrieved", domains));
    }
}
