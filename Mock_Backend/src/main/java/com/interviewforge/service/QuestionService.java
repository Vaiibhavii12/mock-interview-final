package com.interviewforge.service;

import com.interviewforge.model.Question;
import com.interviewforge.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getQuestionsByDomain(String domain) {
        List<Question> questions = questionRepository.findByDomain(domain);
        if (questions.isEmpty()) {
            // Fallback to default domain
            questions = questionRepository.findByDomain("General");
        }
        Collections.shuffle(questions);
        return questions;
    }

    public List<Question> getQuestionsByDomainAndDifficulty(String domain, String difficulty) {
        List<Question> questions = questionRepository.findByDomainAndDifficulty(domain, difficulty);
        if (questions.isEmpty()) {
            questions = questionRepository.findByDomain(domain);
        }
        Collections.shuffle(questions);
        return questions;
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    public List<String> getAllDomains() {
        return questionRepository.findAllDomains();
    }
}
