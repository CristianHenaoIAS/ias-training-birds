package com.birds.application.domain.valueObjects;

import org.apache.commons.lang3.Validate;

public class ConfirmedQuantity {
    private final Integer value;


    public ConfirmedQuantity(Integer value) {
        Validate.notNull(value, "Confirmed quantity cannot not be null");
        Validate.isTrue(value.toString().length() <= 8, "Confirmed quantity can not be longer that 0 characters");
        Validate.inclusiveBetween(1.0 , 100000.0, value, "confirmed quantity only allows values between 1 and 100000");
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
