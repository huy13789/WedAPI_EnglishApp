package com.example.WedAPI.controller;

import com.example.WedAPI.model.Questions;
import com.example.WedAPI.model.Quiz;
import com.example.WedAPI.repository.IQuestionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
    @Autowired
    private IQuestionsRepository iQuestionsRepository;

    //Dùng để lấy danh sách Questions thuộc 1 đề(quiz) truyền vào
    @GetMapping("/getQsQuizId/{quizId}")
    public List<Questions> getAllCategories(@PathVariable Long quizId) {
        return iQuestionsRepository.findQByQuizId(quizId);
    }
}
