package com.architec;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * <h1>The user class</h1>
 * Simply the instance of the user object who is the main holder of the relations with other objects on the back side.
 * The user is able to create multiple questions and questionnaires.
 * <p>
 * @author oleksandr.vladyka
 * @version 1.0
 */

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    /**
     * The last and first name of the user.
     */
    private String name;

    private String password;

    /**
     * The flag to mark the user to give him the right to update and delete the questions.
     */
    private boolean isAuthor;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "user")
    private List<Questionnaire> questionnaires = new LinkedList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "users")
    private List<Question> questions = new LinkedList<>();

    public User(String name, String password, boolean isAuthor) {
        this.name = name;
        this.password = password;
        this.isAuthor = isAuthor;
    }

    public User() {
    }

    /**
     * The method to add a question to the linked list questions. It returns nothing.
     * @param question the only one param.
     */
    public void addQuestion(Question question){
        questions.add(question);
    }

    /**
     * The method to add a questionnaire to the linked list questionnaires and returns nothing.
     * @param questionnaire the only one param.
     */

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
