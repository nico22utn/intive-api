package com.intive.exercise.rent.services.strategies;

public class StrategyRentByWeek implements StrategyRent {
    @Override
    public Double calculateRent() {
        return new Double(60);
    }
}
