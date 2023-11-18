package com.example.WedAPI.service;

import com.example.WedAPI.model.Quiz;

import java.util.List;

public interface QuizService {
    List<Quiz> getQuizByCategoryID(Long id);
}
