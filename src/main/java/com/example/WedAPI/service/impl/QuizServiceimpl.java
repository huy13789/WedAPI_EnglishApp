package com.example.WedAPI.service.impl;

import com.example.WedAPI.model.Quiz;
import com.example.WedAPI.repository.IQuizRespository;
import com.example.WedAPI.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuizServiceimpl implements QuizService {
    @Autowired
    private IQuizRespository iQuizRespository;
    @Override
    public List<Quiz> getQuizByCategoryID(Long id) {
        return iQuizRespository.findByCategoryId(id);
    }
}
