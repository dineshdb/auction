package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "stateId")
public class State {

    @Id
    @GeneratedValue
    private int stateId;

    @Column(unique = true, nullable = false)
    private String stateName;

    @OneToMany(mappedBy = "itemState", targetEntity = Item.class)
    private List<Item> items;

    protected State(){}

    public State(String stateName) {
        this.stateName = stateName;
    }

    public State(int stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    public State(int stateId, String stateName, List<Item> items) {
        this.stateId = stateId;
        this.stateName = stateName;
        this.items = items;
    }

    public List<Item> getItem() {
        return items;
    }

    public void setItem(List<Item> items) {
        this.items = items;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
