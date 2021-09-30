package com.danzig.tenToOne.model;

import javax.persistence.*;

@Entity
@Table(name = "t_player")
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int hp;

    @ManyToOne
    @JoinColumn(name="id_person")
    private Person person;

    public Player(int hp, Person person) {
        this.hp = hp;
        this.person = person;
    }

    public Player(Long id, int hp, Person person) {
        this.id = id;
        this.hp = hp;
        this.person = person;
    }

    public Player() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
