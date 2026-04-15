package com.interviewforge.repository;

import com.interviewforge.model.InterviewAnswer;
import com.interviewforge.model.InterviewSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewAnswerRepository extends JpaRepository<InterviewAnswer, Long> {

    List<InterviewAnswer> findBySession(InterviewSession session);

    List<InterviewAnswer> findBySessionOrderBySubmittedAtAsc(InterviewSession session);

    int countBySession(InterviewSession session);
}
