package com.telusko.QuizService.controller;

import com.telusko.QuizService.model.QuestionWrapper;
import com.telusko.QuizService.model.QuizDto;
import com.telusko.QuizService.Service.QuizService;
import com.telusko.QuizService.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestions(id);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getScore(@PathVariable int id, @RequestParam List<Response> responses){
        return quizService.getScore(id,responses);
    }
}
