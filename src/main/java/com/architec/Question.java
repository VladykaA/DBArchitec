package com.architec;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String filed;

    private int numbers;

    @ManyToOne
    @JoinColumn(name = "question_fk_id")
    private Questionnaire questionnaire;

   /* @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_question",
            joinColumns = @JoinColumn(name = "question_fk_id"),
            inverseJoinColumns = @JoinColumn(name = "user_fk_id"))
    private List<User> users = new ArrayList<>();
*/
    @ElementCollection
    private List<String> answers = new ArrayList<>();;

    @ElementCollection
    @CollectionTable(name = "ways_to_files")
    private List<String> waysToFiles = new ArrayList<>();;


    public Question(String title, String filed, int numbers) {
        this.title = title;
        this.filed = filed;
        this.numbers = numbers;
    }

    public Question() {
    }

//    public void addUser(User user) {
//        users.add(user);
//    }

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

    public String getFiled() {
        return filed;
    }

    public void setFiled(String filed) {
        this.filed = filed;
    }

 /*   public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }*/

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
