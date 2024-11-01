package com.telusko.QuestionService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionWrapper {
    Integer id;
    String title;
    String Option1;
    String Option2;
    String Option3;
    String Option4;
}
