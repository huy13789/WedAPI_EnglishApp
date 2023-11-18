package com.example.WedAPI.repository;

import com.example.WedAPI.model.Category;
import com.example.WedAPI.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRespository extends JpaRepository<Category,Long> {

}

