package com.architec.service.impl;

import com.architec.dao.interfaces.CRUDQuestionnaireDAO;
import com.architec.domain.Questionnaire;
import com.architec.domain.User;
import com.architec.service.QService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

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
    public void update(User user, Questionnaire questionnaire) {
        questionnaireDAO.updateQuestionnaire(user, questionnaire);
    }

    @Override
    public void delete(User user, Questionnaire questionnaire) {
        questionnaireDAO.deleteQuestionnaire(user, questionnaire);
    }
}
