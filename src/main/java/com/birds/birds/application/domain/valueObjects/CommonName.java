package com.birds.birds.application.domain.valueObjects;

import org.apache.commons.lang3.Validate;

public class CommonName {
    private final String value;


    public CommonName(String value) {
        Validate.notNull(value, "null common name should throw an error");
        if(value != null){
            Validate.isTrue(value.length() <= 30, "Bird common name can not be longer then 30 characters");
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
