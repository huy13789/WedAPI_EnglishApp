package com.example.WedAPI.service.impl;

import com.example.WedAPI.model.Category;
import com.example.WedAPI.repository.ICategoryRespository;
import com.example.WedAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceimpl implements CategoryService {
    @Autowired
    private ICategoryRespository iCategoryRespository;
    @Override
    public List<Category> CATEGORY_LIST_LISTEN() {
        List<Category> allCategories = iCategoryRespository.findAll();
        // Sử dụng Java Stream để lọc dữ liệu thỏa mãn điều kiện IsReading == true
        List<Category> readingCategories = allCategories.stream()
                .filter(category -> !category.isReading()) // Sử dụng getter của IsReading
                .collect(Collectors.toList());

        return readingCategories;
    }

    @Override
    public List<Category> CATEGORY_LIST_READING() {
        List<Category> allCategories = iCategoryRespository.findAll();
        // Sử dụng Java Stream để lọc dữ liệu thỏa mãn điều kiện IsReading == true
        List<Category> readingCategories = allCategories.stream()
                .filter(category -> category.isReading()) // Sử dụng getter của IsReading
                .collect(Collectors.toList());

        return readingCategories;
    }
}
