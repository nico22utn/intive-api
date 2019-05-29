package com.intive.exercise.rent.services.strategies;

public class StrategyRentByDay implements StrategyRent {
    @Override
    public Double calculateRent() {
        return new Double(20);
    }
}
