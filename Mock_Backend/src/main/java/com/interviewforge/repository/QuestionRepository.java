package com.interviewforge.repository;

import com.interviewforge.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByDomain(String domain);

    List<Question> findByDomainAndDifficulty(String domain, String difficulty);

    @Query("SELECT q FROM Question q WHERE q.domain = :domain ORDER BY FUNCTION('RANDOM')")
    List<Question> findRandomByDomain(@Param("domain") String domain);

    @Query("SELECT q FROM Question q WHERE q.domain = :domain AND q.difficulty = :difficulty ORDER BY FUNCTION('RANDOM')")
    List<Question> findRandomByDomainAndDifficulty(@Param("domain") String domain, @Param("difficulty") String difficulty);

    @Query("SELECT DISTINCT q.domain FROM Question q")
    List<String> findAllDomains();
}
