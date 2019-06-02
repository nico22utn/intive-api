package com.intive.exercise.rent.services.strategies;

import com.intive.exercise.rent.models.Rent;
import com.intive.exercise.utils.Constants;

import java.util.List;

public class StrategyRentByHour implements StrategyRent {
    @Override
    public Double calculateRent(List<Rent> list) {
        return Constants.AMOUNT_PER_HOUR;
    }
}
