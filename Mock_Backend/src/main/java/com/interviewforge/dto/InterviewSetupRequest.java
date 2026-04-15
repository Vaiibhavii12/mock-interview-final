package com.interviewforge.dto;

import jakarta.validation.constraints.NotBlank;

public class InterviewSetupRequest {

    @NotBlank(message = "Domain is required")
    private String domain;

    @NotBlank(message = "Role is required")
    private String role;

    private String difficulty = "MEDIUM";
    private String companyType = "FAANG";
    private String interviewType = "TECHNICAL";
    private int durationMinutes = 30;

    public InterviewSetupRequest() {}

    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getCompanyType() { return companyType; }
    public void setCompanyType(String companyType) { this.companyType = companyType; }

    public String getInterviewType() { return interviewType; }
    public void setInterviewType(String interviewType) { this.interviewType = interviewType; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }
}
