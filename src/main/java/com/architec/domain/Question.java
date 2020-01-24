package com.architec.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <h1>The class for questions</h1>
 * This class is an entity for question objects.
 * @author oleksandr.vladyka
 * @version 1.0
 */

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;
    /**
     * Title field is a name of the question.
     */
    private String title;

    /**
     * The textFilled is a body of the question.
     */
    private String textFilled;

    /**
     * The numbers is used for numeration of the questions.
     */
    private int numbers;

    /**
     * The field to store questions in questionnaire.
     * @see Questionnaire
     */

    @ManyToOne
    @JoinColumn(name = "questionnaire_fk_id")
    private Questionnaire questionnaire;

    /**
     * The field of the relation with the user.
     * @see User
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinTable(name = "user_question",
            joinColumns = @JoinColumn(name = "question_fk_id"),
            inverseJoinColumns = @JoinColumn(name = "user_fk_id"))
    private List<User> users = new ArrayList<>();

    @ElementCollection
    private List<String> answers = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "ways_to_files")
    private List<String> waysToFiles = new ArrayList<>();

    public Question(String title, String textFilled, int numbers) {
        this.title = title;
        this.textFilled = textFilled;
        this.numbers = numbers;
    }

    public Question() {
    }

    public void addAnswer(String answer) {
        answers.add(answer);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addWay(String way){
        waysToFiles.add(way);
    }

    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextFilled() {
        return textFilled;
    }

    public void setTextFilled(String textFilled) {
        this.textFilled = textFilled;
    }

       public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public List<String> getWaysToFiles() {
        return waysToFiles;
    }

    public void setWaysToFiles(List<String> waysToFiles) {
        this.waysToFiles = waysToFiles;
    }
}
