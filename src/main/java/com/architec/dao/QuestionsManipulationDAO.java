package com.architec.dao;

import com.architec.Question;
import com.architec.User;

public interface QuestionsManipulationDAO {

    Question getQuestionById(int id);

    void updateQuestion(User user, Question question);

    void deleteQuestion(User user, Question question);

}
