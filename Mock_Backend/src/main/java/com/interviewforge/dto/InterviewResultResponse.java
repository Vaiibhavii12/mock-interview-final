package com.interviewforge.dto;

import java.time.LocalDateTime;

public class InterviewResultResponse {

    private Long sessionId;
    private int overallScore;
    private int techScore;
    private int commScore;
    private int probScore;
    private int confScore;
    private String aiFeedback;
    private String domain;
    private String role;
    private int questionsAnswered;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    public InterviewResultResponse() {}

    // Getters and Setters
    public Long getSessionId() { return sessionId; }
    public void setSessionId(Long sessionId) { this.sessionId = sessionId; }

    public int getOverallScore() { return overallScore; }
    public void setOverallScore(int overallScore) { this.overallScore = overallScore; }

    public int getTechScore() { return techScore; }
    public void setTechScore(int techScore) { this.techScore = techScore; }

    public int getCommScore() { return commScore; }
    public void setCommScore(int commScore) { this.commScore = commScore; }

    public int getProbScore() { return probScore; }
    public void setProbScore(int probScore) { this.probScore = probScore; }

    public int getConfScore() { return confScore; }
    public void setConfScore(int confScore) { this.confScore = confScore; }

    public String getAiFeedback() { return aiFeedback; }
    public void setAiFeedback(String aiFeedback) { this.aiFeedback = aiFeedback; }

    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getQuestionsAnswered() { return questionsAnswered; }
    public void setQuestionsAnswered(int questionsAnswered) { this.questionsAnswered = questionsAnswered; }

    public LocalDateTime getStartedAt() { return startedAt; }
    public void setStartedAt(LocalDateTime startedAt) { this.startedAt = startedAt; }

    public LocalDateTime getEndedAt() { return endedAt; }
    public void setEndedAt(LocalDateTime endedAt) { this.endedAt = endedAt; }
}
