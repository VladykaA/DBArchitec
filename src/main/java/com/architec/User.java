package com.architec;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "users")
    private List<Question> questions = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
    }

    public void addQuestion(Question question){
        questions.add(question);
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
}
