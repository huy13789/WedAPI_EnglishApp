package com.example.WedAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TotalQuestionsScoreRespository extends JpaRepository<com.example.WedAPI.model.TotalQuestionsScore,Long> {
}
