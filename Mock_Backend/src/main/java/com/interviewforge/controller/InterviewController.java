package com.interviewforge.controller;

import com.interviewforge.dto.*;
import com.interviewforge.model.InterviewAnswer;
import com.interviewforge.model.InterviewSession;
import com.interviewforge.model.User;
import com.interviewforge.service.AuthService;
import com.interviewforge.service.InterviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/interviews")
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private AuthService authService;

    @PostMapping("/start")
    public ResponseEntity<?> startInterview(@Valid @RequestBody InterviewSetupRequest request,
                                            Authentication authentication) {
        try {
            User user = authService.getUserByEmail(authentication.getName());
            InterviewSession session = interviewService.startInterview(user, request);

            Map<String, Object> response = new HashMap<>();
            response.put("sessionId", session.getId());
            response.put("domain", session.getDomain());
            response.put("role", session.getRole());
            response.put("difficulty", session.getDifficulty());
            response.put("durationMinutes", session.getDurationMinutes());
            response.put("startedAt", session.getStartedAt());

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ApiResponse(true, "Interview started", response));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/{sessionId}/answer")
    public ResponseEntity<?> submitAnswer(@PathVariable Long sessionId,
                                          @Valid @RequestBody AnswerSubmitRequest request,
                                          Authentication authentication) {
        try {
            User user = authService.getUserByEmail(authentication.getName());
            InterviewAnswer answer = interviewService.submitAnswer(sessionId, request, user);

            Map<String, Object> response = new HashMap<>();
            response.put("answerId", answer.getId());
            response.put("score", answer.getScore());
            response.put("relevanceScore", answer.getRelevanceScore());
            response.put("clarityScore", answer.getClarityScore());
            response.put("confidenceScore", answer.getConfidenceScore());
            response.put("feedback", answer.getFeedback());

            return ResponseEntity.ok(new ApiResponse(true, "Answer submitted", response));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/{sessionId}/end")
    public ResponseEntity<?> endInterview(@PathVariable Long sessionId,
                                          Authentication authentication) {
        try {
            User user = authService.getUserByEmail(authentication.getName());
            InterviewResultResponse result = interviewService.endInterview(sessionId, user);
            return ResponseEntity.ok(new ApiResponse(true, "Interview completed", result));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/{sessionId}")
    public ResponseEntity<?> getSession(@PathVariable Long sessionId,
                                        Authentication authentication) {
        try {
            InterviewSession session = interviewService.getSession(sessionId);
            return ResponseEntity.ok(new ApiResponse(true, "Session found", session));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage()));
        }
    }
}
