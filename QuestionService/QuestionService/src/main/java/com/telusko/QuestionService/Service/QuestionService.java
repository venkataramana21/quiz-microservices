package com.telusko.QuestionService.Service;

import com.telusko.QuestionService.model.Question;
import com.telusko.QuestionService.dao.QuestionDao;
import com.telusko.QuestionService.model.QuestionWrapper;
import com.telusko.QuestionService.model.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questiondao;

    public  List<Question> getQuestionsByCategory(String category) {

        return questiondao.findByCategory(category);
    }

    public   List<Question> getAllQuestions() {
        return questiondao.findAll();
    }

    public String addQuestion(Question q) {
         questiondao.save(q);
         return "success";
    }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, Integer numQ) {
        List<Integer>questions= questiondao.getQuestionsForQuiz(category,numQ);
        return new ResponseEntity<>(questions,HttpStatus.OK );
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromIds(List<Integer> ids) {

        List<Question>questions=new ArrayList<>();
        List<QuestionWrapper>wrapper=new ArrayList<>();
        for(Integer i:ids){
            questions.add(questiondao.findById(i).get());
        }
        System.out.println(questions);
        for(Question q: questions){
            QuestionWrapper qw=new QuestionWrapper();
//            BeanUtils.copyProperties(q,qw);
            qw.setId(q.getId());
            qw.setTitle(q.getTitle());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());
            wrapper.add(qw);
        }
        System.out.println(wrapper);
        return new ResponseEntity<>(wrapper,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        int score=0;
        for(Response r:responses){
            Question q=questiondao.findById(r.getId()).get();
            if(r.getResponse().equals(q.getAnswer())){
                score++;
            }
        }
        return new ResponseEntity<>(score,HttpStatus.OK);
    }
}
