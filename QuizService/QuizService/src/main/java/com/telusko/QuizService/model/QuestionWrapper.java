package com.telusko.QuizService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class QuestionWrapper {
    Integer id;
    String title;
    String category;
    String DifficultyLevel;
    String Option1;
    String Option2;
    String Option3;
    String Option4;

}
