package com.birds.birds.application.domain.valueObjects;

import org.apache.commons.lang3.Validate;

public class ZoneName {
    private final String value;


    public ZoneName(String value) {
        Validate.notNull(value, "null Bird zone should throw an error");
        if(value != null){
            Validate.isTrue(value.length() <= 20, "Bird zone name can not be longer then 20 characters");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
