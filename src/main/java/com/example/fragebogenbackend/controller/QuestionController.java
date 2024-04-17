package com.example.fragebogenbackend.controller;

import com.example.fragebogenbackend.model.Participant;
import com.example.fragebogenbackend.model.Question;
import com.example.fragebogenbackend.servis.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/question")
public class QuestionController {


    private final QuestionService questionService;

    @Autowired
    private QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping(path = "register-new-question")
    public void registerNewParticipant(@RequestBody Question question){
        questionService.registerNewQuestion(question);
        System.out.println("CONTACT TO BACKEND ");
        System.out.println("Id: "+question.getId()+"\nText: "+question.getText());
    }

    @GetMapping(path = "get-questions")
    public List<Question> getQuestions(){
        return this.questionService.getQuestion();
    }
}
