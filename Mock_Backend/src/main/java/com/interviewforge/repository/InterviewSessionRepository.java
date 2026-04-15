package com.interviewforge.repository;

import com.interviewforge.model.InterviewSession;
import com.interviewforge.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewSessionRepository extends JpaRepository<InterviewSession, Long> {

    List<InterviewSession> findByUserOrderByStartedAtDesc(User user);

    List<InterviewSession> findByUserAndCompletedTrueOrderByStartedAtDesc(User user);

    @Query("SELECT s FROM InterviewSession s WHERE s.completed = true ORDER BY s.overallScore DESC LIMIT 10")
    List<InterviewSession> findTop10ByCompletedTrueOrderByOverallScoreDesc();

    @Query("SELECT s FROM InterviewSession s WHERE s.completed = true AND s.domain = :domain ORDER BY s.overallScore DESC LIMIT 10")
    List<InterviewSession> findTopByDomain(@Param("domain") String domain);

    @Query("SELECT COUNT(s) FROM InterviewSession s WHERE s.user = :user AND s.completed = true")
    int countCompletedByUser(@Param("user") User user);
}
