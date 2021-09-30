package com.danzig.tenToOne.mapping;

import com.danzig.tenToOne.api.QuestionApiTest;
import com.danzig.tenToOne.api.QuestionGetApi;
import com.danzig.tenToOne.model.Question;

import java.util.ArrayList;
import java.util.List;

public class QuestionMapping {

    public static QuestionApiTest toQuestionApiTest(Question question) {
        return new QuestionApiTest(question.getQuestionContent(), question.getGoodAnswer(), question.getBadAnswer());
    }

    public static Question fromQuestionApi(QuestionApiTest questionApi) {
        return new Question(questionApi.getQuestionContent(), questionApi.getGoodAnswer(), questionApi.getBadAnswer(), false);
    }

    public static List<QuestionApiTest> toQuestionApiTest(List<Question> questions) {
        List<QuestionApiTest> questionApis = new ArrayList<>();
        for(Question question : questions) {
            questionApis.add(toQuestionApiTest(question));
        }
        return questionApis;
     }

    public static QuestionGetApi toQuestionGetApi(Question question) {
        return new QuestionGetApi(question.getQuestionContent(), question.getGoodAnswer(), question.getBadAnswer(), question.getId(), question.getPerson().getId());
    }

    public static List<QuestionGetApi> toQuestionGetApi(List<Question> questions) {
        List<QuestionGetApi> questionGetApis = new ArrayList<>();
        for(Question question : questions) {
            questionGetApis.add(toQuestionGetApi(question));
        }
        return questionGetApis;
    }

}
