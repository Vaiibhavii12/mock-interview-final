package com.interviewforge.service;

import com.interviewforge.dto.LeaderboardEntry;
import com.interviewforge.model.InterviewSession;
import com.interviewforge.repository.InterviewSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeaderboardService {

    @Autowired
    private InterviewSessionRepository sessionRepository;

    public List<LeaderboardEntry> getTopPerformers() {
        List<InterviewSession> sessions = sessionRepository.findTop10ByCompletedTrueOrderByOverallScoreDesc();
        return toLeaderboard(sessions);
    }

    public List<LeaderboardEntry> getTopPerformersByDomain(String domain) {
        List<InterviewSession> sessions = sessionRepository.findTopByDomain(domain);
        return toLeaderboard(sessions);
    }

    private List<LeaderboardEntry> toLeaderboard(List<InterviewSession> sessions) {
        List<LeaderboardEntry> entries = new ArrayList<>();
        int rank = 1;
        for (InterviewSession session : sessions) {
            LeaderboardEntry entry = new LeaderboardEntry(
                    rank++,
                    session.getUser().getFullName(),
                    session.getOverallScore(),
                    session.getUser().getCurrentStreak(),
                    session.getDomain()
            );
            entries.add(entry);
        }
        return entries;
    }
}
