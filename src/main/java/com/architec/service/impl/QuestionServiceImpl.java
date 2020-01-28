package com.architec.service.impl;

import com.architec.dao.interfaces.CRUDQuestionsDAO;
import com.architec.domain.Question;
import com.architec.domain.User;
import com.architec.service.QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionServiceImpl implements QService<User, Question> {

    @Autowired
    @Qualifier("mySQLQuestionDAO")
    private CRUDQuestionsDAO questionsDAO;

    @Override
    public void save(Question question) {
        questionsDAO.saveQuestion(question);
    }

    @Override
    public Question getById(int id) {
        return questionsDAO.getQuestionById(id);
    }

    @Override
    public Question getQByKey(String key) {
        return questionsDAO.getQuestionByKey(key);
    }

    @Override
    public List<Question> getAll() {
        return questionsDAO.getAll();
    }

    @Override
    public void update(Question question) {

    }

    @Override
    public void delete(Question question) {

    }

}
