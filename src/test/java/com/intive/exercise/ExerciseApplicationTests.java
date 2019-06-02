package com.intive.exercise;

import com.intive.exercise.rent.models.Rent;
import com.intive.exercise.rent.models.RentType;
import com.intive.exercise.rent.parameters.StrategyRentType;
import com.intive.exercise.rent.services.RentService;
import com.intive.exercise.rent.services.RentServiceImpl;
import com.intive.exercise.rent.services.strategies.StrategyRentByDay;
import com.intive.exercise.rent.services.strategies.StrategyRentByFamily;
import com.intive.exercise.rent.services.strategies.StrategyRentByHour;
import com.intive.exercise.rent.services.strategies.StrategyRentByWeek;
import com.intive.exercise.user.User;
import com.intive.exercise.utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExerciseApplicationTests {

	private RentService rentService;

	@Before
	public void init() {
		rentService = new RentServiceImpl();
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
