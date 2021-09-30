package com.danzig.tenToOne;

import com.danzig.tenToOne.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private QuestionRepository questionRepository;

    @Autowired
    public Start(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


}
