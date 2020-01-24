package com.architec.dao.interfaces;

import com.architec.domain.Question;
import com.architec.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CRUDQuestionsDAO {

    void saveQuestion(Question question);

    Question getQuestionById(int id);

    List<Question> getAll();

    Question getQuestionByKey(String key);

    void updateQuestion(User user, Question question);

    void deleteQuestion(User user, Question question);

}
