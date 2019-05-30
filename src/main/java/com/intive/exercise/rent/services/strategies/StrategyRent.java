package com.intive.exercise.rent.services.strategies;

import com.intive.exercise.rent.models.Rent;

import java.util.List;

public interface StrategyRent {
     Double calculateRent(List<Rent> list);
}
