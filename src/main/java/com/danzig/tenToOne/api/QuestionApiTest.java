package com.danzig.tenToOne.api;

public class QuestionApiTest {

    private String questionContent;

    private String goodAnswer;

    private String badAnswer;

    public QuestionApiTest(String questionContent, String goodAnswer, String badAnswer) {
        this.questionContent = questionContent;
        this.goodAnswer = goodAnswer;
        this.badAnswer = badAnswer;
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
}
