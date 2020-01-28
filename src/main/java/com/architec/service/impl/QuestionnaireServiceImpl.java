package com.architec.service.impl;

import com.architec.dao.interfaces.CRUDQuestionnaireDAO;
import com.architec.domain.Questionnaire;
import com.architec.domain.User;
import com.architec.service.QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionnaireServiceImpl implements QService<User, Questionnaire> {

    @Autowired
    @Qualifier("mySQLQuestionnaireDAO")
    private CRUDQuestionnaireDAO questionnaireDAO;

    @Override
    public void save(Questionnaire questionnaire) {
        questionnaireDAO.saveQuestionnaire(questionnaire);
    }

    @Override
    public Questionnaire getById(int id) {
        return questionnaireDAO.getQuestionnaireById(id);
    }

    @Override
    public Questionnaire getQByKey(String key) {
        return questionnaireDAO.getQuestionnaireByKey(key);
    }

    @Override
    public List<Questionnaire> getAll() {
        return questionnaireDAO.getAll();
    }

    @Override
    public void update(Questionnaire questionnaire) {

    }

    @Override
    public void delete(Questionnaire questionnaire) {

    }


}
