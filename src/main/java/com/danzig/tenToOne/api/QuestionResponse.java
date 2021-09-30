package com.danzig.tenToOne.api;

import java.util.List;

public class QuestionResponse {

    private PersonApi personApi;

    private List<QuestionApiTest> questionListApi;

    public QuestionResponse(PersonApi personApi, List<QuestionApiTest> questionApi) {
        this.personApi = personApi;
        this.questionListApi = questionApi;
    }

    public PersonApi getPersonApi() {
        return personApi;
    }

    public void setPersonApi(PersonApi personApi) {
        this.personApi = personApi;
    }

    public List<QuestionApiTest> getQuestionListApi() {
        return questionListApi;
    }

    public void setQuestionListApi(List<QuestionApiTest> questionListApi) {
        this.questionListApi = questionListApi;
    }
}
