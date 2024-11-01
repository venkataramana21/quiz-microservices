package com.telusko.QuestionService.dao;

import com.telusko.QuestionService.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository <Question,Integer>{

    List<Question> findByCategory(String category);
    @Query(value = "select * from Question q where q.category=:category ORDER BY RANDOM() limit:numQ",nativeQuery = true)
    List<Question> getQuestions(int numQ, String category);

    @Query(value = "select q.id from Question q where q.category=:category ORDER BY RANDOM() limit :numQ",nativeQuery = true)
    List<Integer> getQuestionsForQuiz(String category, Integer numQ);
}
