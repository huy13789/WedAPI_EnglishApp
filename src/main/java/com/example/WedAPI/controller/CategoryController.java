package com.example.WedAPI.controller;

import com.example.WedAPI.model.Category;
import com.example.WedAPI.model.Quiz;
import com.example.WedAPI.repository.ICategoryRespository;
import com.example.WedAPI.service.CategoryService;
import com.example.WedAPI.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.NumberFormat;
import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private QuizService quizService ;
    @GetMapping("/getall") //reading
    public List<Category> getAllCategories() {
        return categoryService.CATEGORY_LIST_READING();
    }
    @GetMapping("/getallaudio")
    public List<Category> getAllCategoriesAudio() {
        return categoryService.CATEGORY_LIST_LISTEN();
    }
    @GetMapping("/getquizbyCateId/{categoryId}")
    public List<Quiz> getAllCategories(@PathVariable Long categoryId) {
        return quizService.getQuizByCategoryID(categoryId);
    }
}
