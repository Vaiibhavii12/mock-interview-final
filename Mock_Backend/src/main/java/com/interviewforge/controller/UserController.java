package com.interviewforge.controller;

import com.interviewforge.dto.ApiResponse;
import com.interviewforge.model.InterviewSession;
import com.interviewforge.model.User;
import com.interviewforge.service.AuthService;
import com.interviewforge.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private AuthService authService;

    @Autowired
    private InterviewService interviewService;

    @GetMapping("/me")
    public ResponseEntity<?> getCurrentUser(Authentication authentication) {
        try {
            User user = authService.getUserByEmail(authentication.getName());

            Map<String, Object> userData = new HashMap<>();
            userData.put("id", user.getId());
            userData.put("fullName", user.getFullName());
            userData.put("email", user.getEmail());
            userData.put("totalInterviews", user.getTotalInterviews());
            userData.put("bestScore", user.getBestScore());
            userData.put("currentStreak", user.getCurrentStreak());
            userData.put("createdAt", user.getCreatedAt());

            return ResponseEntity.ok(new ApiResponse(true, "User profile", userData));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage()));
        }
    }

    @GetMapping("/me/history")
    public ResponseEntity<?> getInterviewHistory(Authentication authentication) {
        try {
            User user = authService.getUserByEmail(authentication.getName());
            List<InterviewSession> history = interviewService.getUserHistory(user);

            return ResponseEntity.ok(new ApiResponse(true, "Interview history", history));
        } catch (Exception e) {
            return ResponseEntity.badRequest()
                    .body(new ApiResponse(false, e.getMessage()));
        }
    }
}
