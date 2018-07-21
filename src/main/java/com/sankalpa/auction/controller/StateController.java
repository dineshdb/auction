package com.sankalpa.auction.controller;

import com.sankalpa.auction.model.State;
import com.sankalpa.auction.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/states")
    public @ResponseBody List<State> getAllStates(){
        return stateService.getAllStates();
    }

    @GetMapping("/states/{stateId}")
    public @ResponseBody State getState(@PathVariable Long stateId){
        return stateService.getState(stateId);
    }

    @PostMapping("/states")
    public @ResponseBody State addState(@RequestBody State newState){
        return stateService.addState(newState);
    }

    @PutMapping("/states")
    public @ResponseBody State updateState(@RequestBody State updatedState){
        return stateService.updateState(updatedState);
    }

    @DeleteMapping("/states/{stateId}")
    public void deleteState(@PathVariable Long stateId){
        stateService.deleteState(stateId);
    }
}
