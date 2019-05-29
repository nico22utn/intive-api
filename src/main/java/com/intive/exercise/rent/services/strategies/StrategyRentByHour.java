package com.intive.exercise.rent.services.strategies;

public class StrategyRentByHour implements StrategyRent {
    @Override
    public Double calculateRent() {
        return new Double(5);
    }
}
