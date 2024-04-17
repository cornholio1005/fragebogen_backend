package com.example.fragebogenbackend.servis;

import com.example.fragebogenbackend.model.Participant;
import com.example.fragebogenbackend.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;

    @Autowired
    private ParticipantService(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    public List<Participant> getParticipants(){
        return this.participantRepository.findAll();
    }

    public void registerNewParticipant(Participant participant){
        Optional<Participant> participantOptional = this.participantRepository.findParticipantByEmail(participant.getEmail());
        if(participantOptional.isPresent()){
            throw new IllegalStateException("Email already exists");
        }
        this.participantRepository.save(participant);
        System.out.println("#######Registered participant:###### \n" +
                participant.getName()+"\n"+
                participant.getSurname()+"\n");
    }

    public Participant getParticipantByEmail(String participantEmail){
        Participant participant = (Participant) this.participantRepository.findParticipantByEmail(participantEmail)
                .orElseThrow(()->  new IllegalStateException("Patient with email: " + participantEmail + " does not exist"));
        return participant;
    }


}
