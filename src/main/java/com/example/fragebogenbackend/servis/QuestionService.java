package com.example.fragebogenbackend.servis;

import com.example.fragebogenbackend.model.Participant;
import com.example.fragebogenbackend.model.Question;
import com.example.fragebogenbackend.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    private QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public void registerNewQuestion(Question question) {

        this.questionRepository.save(question);
        System.out.println("#######Registered question:###### \n" +
                  question.getText()+"\n");
    }

    public List<Question> getQuestion() {
        return this.questionRepository.findAll();
    }
}
