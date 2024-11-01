package com.telusko.QuizService.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class QuizDto {
    int id;

    String title;

    private List<QuestionWrapper> questions;
}
