package com.intive.exercise.rent.models;

import com.intive.exercise.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode
public class Rent {

    private Date rentDate;
    private Double amount;
    private RentType rentType;
    private User user;
}
