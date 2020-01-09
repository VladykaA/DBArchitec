package com.architec;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.time.*;

/**
 * <h1>This class is the instance for a questionnaire</h1>
 * The questionnaire is a container for questions. Basically it is an entity
 * to connect questions by its topic.
 *
 * @author oleksandr.vladyka
 * @version 1.0
 */

@Entity
@Table(name = "questionnaire")
public class Questionnaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "questionnarie_id")
    private int id;

    /**
     *This field for connection with the user object.
     */
    @ManyToOne
    @JoinColumn(name = "user_fk_id")
    private User user;

    /**
     *The field for connection of the questionnaire with questions. One questionnaire can contain many questions.
     * @see Question
     */
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "questionnaire", orphanRemoval = true)
    private List<Question> questions = new LinkedList<>();

    private LocalDateTime deadLine;

    public Questionnaire(User user, LocalDateTime deadLine) {
        this.user = user;
        this.deadLine = deadLine;
    }

    public Questionnaire() {
    }

    /**
     * The method to add a question to the questionnaire collection.
     * @param question
     */
    public void addQuestionToQuestionnaire(Question question) {
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
