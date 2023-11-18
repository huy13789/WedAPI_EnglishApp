package com.example.WedAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionsScoreRespository extends JpaRepository<com.example.WedAPI.model.QuestionsScore,Long> {
}
