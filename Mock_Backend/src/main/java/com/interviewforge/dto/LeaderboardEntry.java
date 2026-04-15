package com.interviewforge.dto;

public class LeaderboardEntry {

    private int rank;
    private String fullName;
    private int score;
    private int streak;
    private String domain;
    private String avatarUrl;

    public LeaderboardEntry() {}

    public LeaderboardEntry(int rank, String fullName, int score, int streak, String domain) {
        this.rank = rank;
        this.fullName = fullName;
        this.score = score;
        this.streak = streak;
        this.domain = domain;
        this.avatarUrl = "https://i.pravatar.cc/28?u=" + fullName.hashCode();
    }

    // Getters and Setters
    public int getRank() { return rank; }
    public void setRank(int rank) { this.rank = rank; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }

    public int getStreak() { return streak; }
    public void setStreak(int streak) { this.streak = streak; }

    public String getDomain() { return domain; }
    public void setDomain(String domain) { this.domain = domain; }

    public String getAvatarUrl() { return avatarUrl; }
    public void setAvatarUrl(String avatarUrl) { this.avatarUrl = avatarUrl; }
}
