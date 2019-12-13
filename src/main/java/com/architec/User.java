package com.architec;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String password;

    private boolean isAuthor;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user", orphanRemoval = true)
    private List<Questionnaire> questionnaires = new ArrayList<>();;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "users")
    private List<Question> questions = new ArrayList<>();

    public User(String name, String password, boolean isAuthor) {
        this.name = name;
        this.password = password;
        this.isAuthor = isAuthor;
    }

    public User() {
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public void addQuestionnaire(Questionnaire questionnaire){
        questionnaires.add(questionnaire);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAuthor() {
        return isAuthor;
    }

    public void setAuthor(boolean author) {
        isAuthor = author;
    }

    public List<Questionnaire> getQuestionnaires() {
        return questionnaires;
    }

    public void setQuestionnaires(List<Questionnaire> questionnaires) {
        this.questionnaires = questionnaires;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
