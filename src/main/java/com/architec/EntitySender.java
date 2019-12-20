package com.architec;

import com.architec.dao.mysql.MySQLUserDAO;

public class EntitySender {
    public static void main(String[] args) {

        MySQLUserDAO userDAO = new MySQLUserDAO();

        User user1 = new User("Sam", "123", true);
        Questionnaire questionnaire1 = new Questionnaire(user1);
        Question question1 = new Question("Tile-1","Some text", 1);
        user1.addQuestionnaire(questionnaire1);
        questionnaire1.addQuestionToQuestionnaire(question1);

        userDAO.saveUser(user1);

    }
}
