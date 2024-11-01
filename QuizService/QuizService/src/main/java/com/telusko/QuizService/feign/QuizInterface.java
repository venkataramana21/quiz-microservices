package com.telusko.QuizService.feign;

import com.telusko.QuizService.model.QuestionWrapper;
import com.telusko.QuizService.model.Response;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QuestionService")
public interface QuizInterface {
    @GetMapping("/question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQ);

    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(@RequestBody List<Integer> ids);

    @PostMapping("/question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
