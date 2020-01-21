package com.architec.service;

import com.architec.domain.Question;

public interface QuestionService extends CRUDService<Question> {
    void getByKeyWord();
}
