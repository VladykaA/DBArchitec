package com.architec.dao;

import com.architec.domain.Question;
import com.architec.domain.User;
//TODO rename the interface name
public interface QuestionsManipulationDAO {

    Question getQuestionById(int id);

    void updateQuestion(User user, Question question);

    void deleteQuestion(User user, Question question);

}
