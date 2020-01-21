package com.architec;

import com.architec.dao.mysql.MySQLUserDAO;
import com.architec.domain.Question;
import com.architec.domain.User;

public class EntitySender {
    public static void main(String[] args) {

        MySQLUserDAO userDAO = new MySQLUserDAO();

        /*User user1 = new User("Ray", "1234ddfdf5", true);

        Questionnaire questionnaire1 = new Questionnaire(user1, LocalDateTime.now());
        user1.addQuestionnaire(questionnaire1);

        Question question1 = new Question("Tile-111","Some text3", 1);
        Question question2 = new Question("Tile-212","Some text3", 2);

        questionnaire1.addQuestionToQuestionnaire(question1);
        questionnaire1.addQuestionToQuestionnaire(question2);

        question1.setQuestionnaire(questionnaire1);

        user1.addQuestion(question1);
        user1.addQuestion(question2);

        question1.addUser(user1);
        question2.addUser(user1);

        question1.addAnswer("Answer 111");
        question2.addAnswer("Answer 222");

        question1.addWay("some string to file1");

        userDAO.saveUser(user1);*/

        User user = userDAO.getUserById(2);

        Question question = userDAO.getQuestionById(3);

        //userDAO.deleteUser(user);

        /*user.setName("Tom");

        user.setPassword("111111");

        user.getQuestionnaires()
                .get(0)
                .setDeadLine(LocalDateTime.of(2020, 01, 01, 3, 5));

        userDAO.updateUser(user);*/

        userDAO.deleteQuestion(user, question);

    }
}
