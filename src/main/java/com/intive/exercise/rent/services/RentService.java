package com.intive.exercise.rent.services;

import com.intive.exercise.rent.models.Rent;
import com.intive.exercise.rent.models.RentType;
import com.intive.exercise.user.User;

public interface RentService {

    /**
     * This method creates a new rent and will use strategies to calculate amount
     *
     * @param user
     * @param rentType
     * @return
     * @throws Exception
     */
    Rent createRent(User user, RentType rentType) throws Exception;
}
