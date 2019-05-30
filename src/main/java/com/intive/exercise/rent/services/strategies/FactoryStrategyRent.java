package com.intive.exercise.rent.services.strategies;

import com.intive.exercise.rent.models.Rent;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode
public class FactoryStrategyRent {
    static FactoryStrategyRent instance;

    public  StrategyRent getStrategy(Rent rent) throws Exception{
        Optional.ofNullable(rent).orElseThrow( () -> new Exception("Rent can't be null"));
        StrategyRent strategyRent;
        if (rent.getRentType().getStrategyRentType().getStrategyName().equals(StrategyRentByDay.class.getName())) {
            strategyRent = new StrategyRentByDay();
        } else if (rent.getRentType().getStrategyRentType().getStrategyName().equals(StrategyRentByHour.class.getName()) ) {
            strategyRent = new StrategyRentByHour();
        } else if (rent.getRentType().getStrategyRentType().getStrategyName().equals(StrategyRentByWeek.class.getName())){
            strategyRent = new StrategyRentByWeek();
        } else {
            strategyRent = new StrategyRentByFamily();
        }
        return strategyRent;
    }
}
