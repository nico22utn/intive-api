package com.intive.exercise.rent.services;

import com.intive.exercise.rent.models.Rent;
import com.intive.exercise.rent.models.RentType;
import com.intive.exercise.rent.services.strategies.FactoryStrategyRent;
import com.intive.exercise.rent.services.strategies.StrategyRent;
import com.intive.exercise.user.User;
import java.util.Date;
import java.util.List;

public class RentServiceImpl implements RentService {

    @Override
    public Rent createRent(User user, RentType rentType, List<Rent> list) throws Exception {

        Rent rent = new Rent();
        rent.setRentType(rentType);
        rent.setUser(user);
        rent.setRentDate(new Date());
        //Now we'll calculate amount
        FactoryStrategyRent factoryStrategyRent = new FactoryStrategyRent();
        StrategyRent strategyRent = factoryStrategyRent.getStrategy(rent);
        Double amount = strategyRent.calculateRent(list);
        rent.setAmount(amount);
        return rent;
    }

}
