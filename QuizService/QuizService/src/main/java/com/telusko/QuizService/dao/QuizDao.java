package com.telusko.QuizService.dao;

import com.telusko.QuizService.model.Quiz;
import com.telusko.QuizService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {

}
