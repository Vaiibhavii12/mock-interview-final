package com.interviewforge.controller;

import com.interviewforge.dto.ApiResponse;
import com.interviewforge.dto.LeaderboardEntry;
import com.interviewforge.service.LeaderboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaderboard")
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @GetMapping
    public ResponseEntity<?> getLeaderboard(
            @RequestParam(required = false) String domain) {

        List<LeaderboardEntry> entries;
        if (domain != null && !domain.isEmpty()) {
            entries = leaderboardService.getTopPerformersByDomain(domain);
        } else {
            entries = leaderboardService.getTopPerformers();
        }

        return ResponseEntity.ok(new ApiResponse(true, "Leaderboard retrieved", entries));
    }
}
