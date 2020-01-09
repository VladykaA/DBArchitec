package com.architec;

import com.architec.dao.mysql.MySQLUserDAO;

import java.time.LocalDateTime;

public class EntitySender {
    public static void main(String[] args) {

        MySQLUserDAO userDAO = new MySQLUserDAO();

        /*User user1 = new User("Tom", "12345", true);

        Questionnaire questionnaire1 = new Questionnaire(user1, LocalDateTime.now());
        user1.addQuestionnaire(questionnaire1);

        Question question1 = new Question("Tile-11","Some text2", 1);
        Question question2 = new Question("Tile-21","Some text2", 2);

        questionnaire1.addQuestionToQuestionnaire(question1);
        questionnaire1.addQuestionToQuestionnaire(question2);

        question1.setQuestionnaire(questionnaire1);

        user1.addQuestion(question1);
        user1.addQuestion(question2);

        question1.addUser(user1);
        question2.addUser(user1);

        question1.addAnswer("Answer 11");
        question2.addAnswer("Answer 22");

        question1.addWay("some string to file1");*/

        //userDAO.saveUser(user1);


        User user = userDAO.getUserById(1);

        Question question = userDAO.getQuestionById(1);

        /*userDAO.deleteUser(user);

        user.setName("Tom");

        user.setPassword("111111");

        user.getQuestionnaires()
                .get(0)
                .setDeadLine(LocalDateTime.of(2020, 01, 01, 3, 5));

        userDAO.updateUser(user);*/

        userDAO.deleteQuestion(user, question);

    }
}
