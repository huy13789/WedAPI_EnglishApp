package com.example.WedAPI.service;

import com.example.WedAPI.model.Category;
import com.example.WedAPI.model.User;

import java.util.List;

public interface CategoryService {
    List<Category> CATEGORY_LIST_READING();
    List<Category> CATEGORY_LIST_LISTEN();
}
