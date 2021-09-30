package com.danzig.tenToOne.api;

public class QuestionRequest {

    private PersonApi personApi;

    private QuestionApiTest questionApi;

    public PersonApi getPersonApi() {
        return personApi;
    }

    public void setPersonApi(PersonApi personApi) {
        this.personApi = personApi;
    }

    public QuestionApiTest getQuestionApi() {
        return questionApi;
    }

    public void setQuestionApi(QuestionApiTest questionApi) {
        this.questionApi = questionApi;
    }
}
