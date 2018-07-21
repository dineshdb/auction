package com.sankalpa.auction.service;

import com.sankalpa.auction.model.State;
import com.sankalpa.auction.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates(){
        List<State> states = new ArrayList<>();
        stateRepository.findAll().forEach(states::add);
        return states;
    }

    public State addState(State newState){
        return stateRepository.save(newState);
    }

    public State updateState(State updatedState){
        return stateRepository.save(updatedState);
    }

    public void deleteState(Long stateId){
        stateRepository.deleteById(stateId);
    }

    public State getState(Long stateId){
        return stateRepository.findById(stateId).orElse(null);
    }
}
