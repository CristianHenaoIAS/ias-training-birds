package com.birds.application.domain.valueObjects;

import org.apache.commons.lang3.Validate;

public class ScientificName {
    private final String value;

    public ScientificName(String value) {
        Validate.notNull(value, "null scientific name should throw an error");
        if(value != null){
            Validate.isTrue(value.length() <= 30, "Bird scientific name can not be longer then 30 characters");
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
