package com.telusko.QuizService.Service;

import com.telusko.QuizService.feign.QuizInterface;
import com.telusko.QuizService.model.*;

import com.telusko.QuizService.dao.QuizDao;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
       List<Integer>questionsIds=quizInterface.getQuestionsForQuiz(category,numQ).getBody();
       Quiz q=new Quiz();
       q.setTitle(title);
       q.setQuestionIds(questionsIds);
       quizDao.save(q);
       return new ResponseEntity<>("Success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {

       List<Integer>QuestionIds=quizDao.findById(id).get().getQuestionIds();
       List<QuestionWrapper>qw=quizInterface.getQuestionsFromIds(QuestionIds).getBody();
       return new ResponseEntity<>(qw,HttpStatus.OK);
    }
//
    public ResponseEntity<Integer> getScore(int id, List<Response> responses) {
   return  quizInterface.getScore(responses);
    }
}
