package com.architec.dao.interfaces;

import com.architec.domain.Questionnaire;
import com.architec.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CRUDQuestionnaireDAO {

    void saveQuestionnaire(Questionnaire questionnaire);

    Questionnaire getQuestionnaireById(int id);

    Questionnaire getQuestionnaireByKey(String key);

    List<Questionnaire> getAll();

    void updateQuestionnaire(User user, Questionnaire question);

    void deleteQuestionnaire(User user, Questionnaire question);
}
