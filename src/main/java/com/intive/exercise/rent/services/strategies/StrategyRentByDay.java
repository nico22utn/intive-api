package com.intive.exercise.rent.services.strategies;

import com.intive.exercise.rent.models.Rent;

import java.util.List;

public class StrategyRentByDay implements StrategyRent {
    @Override
    public Double calculateRent(List<Rent> list) {
        return new Double(20);
    }
}
