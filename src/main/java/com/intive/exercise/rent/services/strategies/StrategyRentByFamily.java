package com.intive.exercise.rent.services.strategies;

import com.intive.exercise.rent.models.Rent;

import java.util.List;
import java.util.Optional;

public class StrategyRentByFamily implements StrategyRent {
    @Override
    public Double calculateRent(List<Rent> list) {

        Double amounts = 0.0;
        if ( checkIfRentsHasSufficient(list)) {
            amounts = list.stream().mapToDouble( Rent::getAmount).sum();
        }
        amounts = amounts * 0.3;
        return amounts;
    }

    private Boolean checkIfRentsHasSufficient(List<Rent> rentList){
        Integer rentArrayLength = rentList.size();
        if (rentArrayLength >= 3 && rentArrayLength <= 5) {
            return true;
        }
        return false;
    }
}
