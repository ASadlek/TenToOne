package com.danzig.tenToOne.model;


import javax.persistence.*;

@Entity
@Table(name = "t_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String questionContent;

    @Column(nullable = false)
    private String goodAnswer;

    @Column(nullable = false)
    private String badAnswer;

    @Column(nullable = false)
    private boolean asked = false;

    @ManyToOne
    @JoinColumn(name="id_person")
    private Person person;

    public Question(Long id, String questionContent, String goodAnswer, String badAnswer, boolean asked) {
        this.id = id;
        this.questionContent = questionContent;
        this.goodAnswer = goodAnswer;
        this.badAnswer = badAnswer;
        this.asked = asked;

    }

    public Question(String questionContent, String goodAnswer, String badAnswer, boolean asked) {
        this.questionContent = questionContent;
        this.goodAnswer = goodAnswer;
        this.badAnswer = badAnswer;
        this.asked = asked;
    }

    public Question() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
