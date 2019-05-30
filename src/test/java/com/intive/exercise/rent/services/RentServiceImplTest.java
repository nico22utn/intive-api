package com.intive.exercise.rent.services;

import com.intive.exercise.rent.models.Rent;
import com.intive.exercise.rent.models.RentType;
import com.intive.exercise.rent.parameters.StrategyRentType;
import com.intive.exercise.rent.services.strategies.*;
import com.intive.exercise.user.User;
import com.intive.exercise.utils.Constants;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RentServiceImplTest {

    private RentService rentService;

    @Test
    public void testCreateRentWithListRentEmptyAndStrategyRentByFamily() throws Exception {

        // Mocks
        StrategyRentType strategyRentType = new StrategyRentType();
        strategyRentType.setStrategyName(StrategyRentByFamily.class.getName());
        RentType rentType = new RentType();
        rentType.setId(1L);
        rentType.setStrategyRentType(strategyRentType);
        User user = new User();
        user.setUsername("TESTUSER");
        List<Rent> rentList = new ArrayList<>();
        //Should be wrong
        Double aDouble = new Double(0.0);
        Assert.assertNotEquals(aDouble,rentService.createRent(user,rentType,rentList).getAmount());
    }

    @Test
    public void testCreateRentWhenUserIsNull() throws Exception {
        // Mocks
        StrategyRentType strategyRentType = new StrategyRentType();
        strategyRentType.setStrategyName(StrategyRentByDay.class.getName());
        RentType rentType = new RentType();
        rentType.setId(1L);
        rentType.setStrategyRentType(strategyRentType);
        User user = new User();
        user.setUsername("TESTUSER");
        Assert.assertNotEquals(null,rentService.createRent(new User(),rentType,new ArrayList<>()).getUser());
    }

    @Test
    public void testCreateRentCorrectlyWithStrategyRentPerDay() throws Exception {
        // Mocks
        StrategyRentType strategyRentType = new StrategyRentType();
        strategyRentType.setStrategyName(StrategyRentByDay.class.getName());
        RentType rentType = new RentType();
        rentType.setId(1L);
        rentType.setStrategyRentType(strategyRentType);
        User user = new User();
        user.setUsername("TESTUSER");
        Assert.assertEquals(Constants.AMOUNT_PER_DAY,rentService.createRent(user,rentType,new ArrayList<>()).getAmount());
    }

    @Test
    public void testCreateRentCorrectlyWithStrategyRentPerHour() throws Exception {
        // Mocks
        StrategyRentType strategyRentType = new StrategyRentType();
        strategyRentType.setStrategyName(StrategyRentByHour.class.getName());
        RentType rentType = new RentType();
        rentType.setId(1L);
        rentType.setStrategyRentType(strategyRentType);
        User user = new User();
        user.setUsername("TESTUSER");
        Assert.assertEquals(Constants.AMOUNT_PER_HOUR,rentService.createRent(user,rentType,new ArrayList<>()).getAmount());
    }

    @Test
    public void testCreateRentCorrectlyWithStrategyRentPerWeek() throws Exception {
        // Mocks
        StrategyRentType strategyRentType = new StrategyRentType();
        strategyRentType.setStrategyName(StrategyRentByWeek.class.getName());
        RentType rentType = new RentType();
        rentType.setId(1L);
        rentType.setStrategyRentType(strategyRentType);
        User user = new User();
        user.setUsername("TESTUSER");
        Assert.assertEquals(Constants.AMOUNT_PER_WEEK,rentService.createRent(user,rentType,new ArrayList<>()).getAmount());
    }
}