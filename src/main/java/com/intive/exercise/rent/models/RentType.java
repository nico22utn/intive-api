package com.intive.exercise.rent.models;

import com.intive.exercise.rent.parameters.StrategyRentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class RentType {

    private Long id;
    private String rentTypeName;
    private StrategyRentType strategyRentType;
}
