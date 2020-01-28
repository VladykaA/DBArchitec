package com.architec;

import com.architec.configuration.ConfigApp;
import com.architec.domain.Question;
import com.architec.domain.Questionnaire;
import com.architec.domain.User;
import com.architec.service.CRUDService;
import com.architec.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class EntitySender {
    public static void main(String[] args) {

        ApplicationContext context = new
                AnnotationConfigApplicationContext(ConfigApp.class);

        CRUDService<User> userService = context.getBean(UserServiceImpl.class);

        User user1 = new User("Mark", "2rrrrrrr", true);

        Questionnaire questionnaire1 = new Questionnaire(user1, LocalDateTime.now());
        user1.addQuestionnaire(questionnaire1);

        Question question1 = new Question("Tile-21mark","Some text21mark", 1);
        Question question2 = new Question("Tile-22mark","Some text22mark", 2);

        questionnaire1.addQuestionToQuestionnaire(question1);
        questionnaire1.addQuestionToQuestionnaire(question2);

        question1.setQuestionnaire(questionnaire1);

        user1.addQuestion(question1);
        user1.addQuestion(question2);

        question1.addUser(user1);
        question2.addUser(user1);

        question1.addAnswer("Answer 21mark");
        question2.addAnswer("Answer 21mark");

        question1.addWay("some string to file1 mark");

        userService.save(user1);

        //userDAO.deleteUser(user);

        /*user.setName("Tom");

        user.setPassword("111111");

        user.getQuestionnaires()
                .get(0)
                .setDeadLine(LocalDateTime.of(2020, 01, 01, 3, 5));

        userDAO.updateUser(user);*/

    }
}
