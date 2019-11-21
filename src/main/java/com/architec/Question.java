package com.architec;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;

    private String filed;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_question",
            joinColumns = @JoinColumn(name = "question_fk_id"),
            inverseJoinColumns = @JoinColumn(name = "user_fk_id"))
    private List<User> users = new ArrayList<>();

    public Question(String title, String filed) {
        this.title = title;
        this.filed = filed;
    }

    public Question() {
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
}
