package com.danzig.tenToOne.service;


import com.danzig.tenToOne.model.Question;
import com.danzig.tenToOne.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = questionRepository.findAll();
        return questions;
    }


    public Question addQuestion(Question question) {
        Question newQuestion = questionRepository.save(question);
        return newQuestion;
    }

    public Optional<Question> questionById (Long id) {
        return questionRepository.findById(id);
    }

    public Question updateQuestion(Question question) {
        Question newQuestion = questionRepository.save(question);
        return newQuestion;
    }

    public void deleteQuestionById (Long id) {
        questionRepository.deleteById(id);
    }
}
