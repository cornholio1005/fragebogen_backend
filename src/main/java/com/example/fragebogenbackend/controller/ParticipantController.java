package com.example.fragebogenbackend.controller;

import com.example.fragebogenbackend.model.Participant;
import com.example.fragebogenbackend.servis.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/participant")
public class ParticipantController {
    private final ParticipantService participantService;

    @Autowired
    private ParticipantController(ParticipantService participantService){
        this.participantService = participantService;
    }

    @GetMapping(path = "get-participants")
    public List<Participant> getParticipants(){
        return this.participantService.getParticipants();
    }

    @PostMapping(path = "register-new-participant")
    public void registerNewParticipant(@RequestBody Participant participant){
        participantService.registerNewParticipant(participant);
    }

    @GetMapping(path = "get-participant-by-email/{email}")
    public Participant getParticipantByEmail(@PathVariable String email){
        return this.participantService.getParticipantByEmail(email);
    }
}
