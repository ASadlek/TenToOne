package com.danzig.tenToOne.api;

public class QuestionGetApi {

    private String questionContent;

    private String goodAnswer;

    private String badAnswer;

    private Long id;

    private Long id_person;

    public QuestionGetApi(String questionContent, String goodAnswer, String badAnswer, Long id, Long id_person) {
        this.questionContent = questionContent;
        this.goodAnswer = goodAnswer;
        this.badAnswer = badAnswer;
        this.id = id;
        this.id_person = id_person;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getGoodAnswer() {
        return goodAnswer;
    }

    public void setGoodAnswer(String goodAnswer) {
        this.goodAnswer = goodAnswer;
    }

    public String getBadAnswer() {
        return badAnswer;
    }

    public void setBadAnswer(String badAnswer) {
        this.badAnswer = badAnswer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_person() {
        return id_person;
    }

    public void setId_person(Long id_person) {
        this.id_person = id_person;
    }
}
