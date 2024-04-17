package com.example.fragebogenbackend.repository;

import com.example.fragebogenbackend.model.Participant;
import com.example.fragebogenbackend.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>  {

    Optional<Question> findQuestionById(Long id);
}
