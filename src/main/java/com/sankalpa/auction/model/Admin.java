package com.sankalpa.auction.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ADMIN")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userId")
public class Admin extends User {

    public Admin(){}

    public Admin(Long userId, String userEmail, String userPassword) {
        super(userId, userEmail, userPassword);
    }

    public Admin(String userEmail, String userPassword) {
        super(userEmail, userPassword);
    }
}
