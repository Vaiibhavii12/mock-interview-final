package com.interviewforge.service;

import com.interviewforge.dto.AnswerSubmitRequest;
import com.interviewforge.dto.InterviewResultResponse;
import com.interviewforge.dto.InterviewSetupRequest;
import com.interviewforge.model.*;
import com.interviewforge.repository.InterviewAnswerRepository;
import com.interviewforge.repository.InterviewSessionRepository;
import com.interviewforge.repository.QuestionRepository;
import com.interviewforge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
public class InterviewService {

    @Autowired
    private InterviewSessionRepository sessionRepository;

    @Autowired
    private InterviewAnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    private final Random random = new Random();

    public InterviewSession startInterview(User user, InterviewSetupRequest request) {
        InterviewSession session = new InterviewSession();
        session.setUser(user);
        session.setDomain(request.getDomain());
        session.setRole(request.getRole());
        session.setDifficulty(request.getDifficulty());
        session.setCompanyType(request.getCompanyType());
        session.setInterviewType(request.getInterviewType());
        session.setDurationMinutes(request.getDurationMinutes());
        session.setStartedAt(LocalDateTime.now());

        return sessionRepository.save(session);
    }

    public InterviewAnswer submitAnswer(Long sessionId, AnswerSubmitRequest request, User user) {
        InterviewSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        if (!session.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized access to session");
        }

        if (session.isCompleted()) {
            throw new RuntimeException("Interview already completed");
        }

        Question question = questionRepository.findById(request.getQuestionId())
                .orElseThrow(() -> new RuntimeException("Question not found"));

        // Score the answer (simulated AI scoring based on answer length, keywords, etc.)
        int[] scores = scoreAnswer(request.getAnswerText(), question);

        InterviewAnswer answer = new InterviewAnswer();
        answer.setSession(session);
        answer.setQuestion(question);
        answer.setAnswerText(request.getAnswerText());
        answer.setScore(scores[0]);
        answer.setRelevanceScore(scores[1]);
        answer.setClarityScore(scores[2]);
        answer.setConfidenceScore(scores[3]);
        answer.setFeedback(generateAnswerFeedback(scores[0], question.getDomain()));
        answer.setSubmittedAt(LocalDateTime.now());

        session.setQuestionsAnswered(session.getQuestionsAnswered() + 1);
        sessionRepository.save(session);

        return answerRepository.save(answer);
    }

    public InterviewResultResponse endInterview(Long sessionId, User user) {
        InterviewSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        if (!session.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Unauthorized access to session");
        }

        // Calculate final scores from answers
        List<InterviewAnswer> answers = answerRepository.findBySession(session);
        int totalScore = 0, totalRelevance = 0, totalClarity = 0, totalConfidence = 0;

        if (!answers.isEmpty()) {
            for (InterviewAnswer a : answers) {
                totalScore += a.getScore();
                totalRelevance += a.getRelevanceScore();
                totalClarity += a.getClarityScore();
                totalConfidence += a.getConfidenceScore();
            }
            int count = answers.size();
            session.setTechScore(totalScore / count);
            session.setCommScore(totalClarity / count);
            session.setProbScore(totalRelevance / count);
            session.setConfScore(totalConfidence / count);
        } else {
            // No answers submitted — give base scores
            session.setTechScore(30 + random.nextInt(20));
            session.setCommScore(35 + random.nextInt(20));
            session.setProbScore(25 + random.nextInt(20));
            session.setConfScore(40 + random.nextInt(20));
        }

        int overall = (session.getTechScore() + session.getCommScore()
                + session.getProbScore() + session.getConfScore()) / 4;
        session.setOverallScore(overall);
        session.setEndedAt(LocalDateTime.now());
        session.setCompleted(true);
        session.setAiFeedback(generateAIFeedback(overall, session.getTechScore(),
                session.getCommScore(), session.getProbScore(), session.getConfScore()));

        sessionRepository.save(session);

        // Update user stats
        User u = session.getUser();
        u.setTotalInterviews(u.getTotalInterviews() + 1);
        if (overall > u.getBestScore()) {
            u.setBestScore(overall);
        }
        u.setCurrentStreak(u.getCurrentStreak() + 1);
        userRepository.save(u);

        // Build response
        InterviewResultResponse result = new InterviewResultResponse();
        result.setSessionId(session.getId());
        result.setOverallScore(session.getOverallScore());
        result.setTechScore(session.getTechScore());
        result.setCommScore(session.getCommScore());
        result.setProbScore(session.getProbScore());
        result.setConfScore(session.getConfScore());
        result.setAiFeedback(session.getAiFeedback());
        result.setDomain(session.getDomain());
        result.setRole(session.getRole());
        result.setQuestionsAnswered(session.getQuestionsAnswered());
        result.setStartedAt(session.getStartedAt());
        result.setEndedAt(session.getEndedAt());

        return result;
    }

    public List<InterviewSession> getUserHistory(User user) {
        return sessionRepository.findByUserAndCompletedTrueOrderByStartedAtDesc(user);
    }

    public InterviewSession getSession(Long sessionId) {
        return sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }

    // ===== Simulated Answer Scoring =====
    private int[] scoreAnswer(String answer, Question question) {
        int baseScore = 40;
        int length = answer.length();

        // Length-based scoring
        if (length > 500) baseScore += 25;
        else if (length > 200) baseScore += 20;
        else if (length > 100) baseScore += 15;
        else if (length > 50) baseScore += 10;
        else baseScore += 5;

        // Keyword match scoring (simple heuristic)
        String lowerAnswer = answer.toLowerCase();
        String lowerQuestion = question.getQuestionText().toLowerCase();

        String[] techKeywords = {"algorithm", "complexity", "data structure", "time", "space",
                "array", "tree", "graph", "stack", "queue", "hash", "sort", "search",
                "database", "api", "rest", "sql", "server", "client", "http",
                "react", "component", "state", "dom", "css", "javascript",
                "machine learning", "model", "training", "neural", "regression"};

        int keywordHits = 0;
        for (String keyword : techKeywords) {
            if (lowerAnswer.contains(keyword)) keywordHits++;
        }
        baseScore += Math.min(keywordHits * 3, 20);

        // Cap and randomize slightly
        int score = Math.min(98, baseScore + random.nextInt(10));
        int relevance = Math.min(98, score - 5 + random.nextInt(15));
        int clarity = Math.min(98, score - 3 + random.nextInt(12));
        int confidence = Math.min(98, score + random.nextInt(10));

        return new int[]{score, relevance, clarity, confidence};
    }

    private String generateAnswerFeedback(int score, String domain) {
        if (score >= 85) {
            return "Excellent answer! You demonstrated strong understanding of " + domain + " concepts.";
        } else if (score >= 70) {
            return "Good answer. Consider adding more specific examples and technical depth.";
        } else if (score >= 55) {
            return "Decent attempt. Try to be more structured — use the STAR method for behavioral questions or break down technical problems step by step.";
        } else {
            return "Needs improvement. Review the core concepts and practice articulating your thought process clearly.";
        }
    }

    private String generateAIFeedback(int overall, int tech, int comm, int prob, int conf) {
        StringBuilder fb = new StringBuilder();

        if (overall >= 80) {
            fb.append("Outstanding performance! Your ").append(overall)
                    .append("% score places you in the top 10% of candidates. ");
        } else if (overall >= 60) {
            fb.append("Good performance with ").append(overall)
                    .append("/100! You showed solid fundamentals. ");
        } else {
            fb.append("Room for improvement at ").append(overall)
                    .append("/100. More practice will help significantly. ");
        }

        // Specific feedback per category
        if (tech < 60) fb.append("Focus on strengthening your technical knowledge — practice DSA and system design problems daily. ");
        if (comm < 60) fb.append("Work on communication — practice explaining concepts clearly and concisely. ");
        if (prob < 60) fb.append("Improve problem-solving — practice breaking down problems into smaller components. ");
        if (conf < 60) fb.append("Build confidence — practice more mock interviews and speak with conviction. ");

        if (tech >= 80) fb.append("Your technical skills are impressive! ");
        if (comm >= 80) fb.append("Your communication is clear and well-structured. ");

        fb.append("Keep practicing and you'll see great improvement!");

        return fb.toString();
    }
}
