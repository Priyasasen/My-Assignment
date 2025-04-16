package com.hexaware.pps.entity;

import java.util.ArrayList;
import java.util.List;

public class AdoptionEvents {
    private List<IAdoptable> participants;

    public AdoptionEvents() {
        participants = new ArrayList<>();
    }

    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
    }

    public void hostEvent() {
        System.out.println(" Adoption Event Started!");
        for (IAdoptable participant : participants) {
            participant.adopt(); 
        }
        System.out.println("Adoption Event Ended!");
    }
}
