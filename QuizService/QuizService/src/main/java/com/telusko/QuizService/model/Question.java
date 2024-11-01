package com.telusko.QuizService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Question {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    Integer id;
    String title;
    String category;
    String DifficultyLevel;
    String Option1;
    String Option2;
    String Option3;
    String Option4;
    String Answer;

}
