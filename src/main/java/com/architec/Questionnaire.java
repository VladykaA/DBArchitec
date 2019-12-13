package com.architec;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.time.*;

@Entity
public class Questionnaire {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_fk-id")
    private User user;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "questionnaire", orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    private LocalDateTime deadLine;


    public Questionnaire(User user) {
        this.user = user;
    }

    public Questionnaire() {
    }

    public void addQuestionToQuestionnaire(Question question){
        questions.add(question);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public LocalDateTime getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDateTime deadLine) {
        this.deadLine = deadLine;
    }
}
