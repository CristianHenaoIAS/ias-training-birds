package com.birds.birds.application.domain.valueObjects;

import org.apache.commons.lang3.Validate;

public class BirdId {
    private final Long value;

    public BirdId(Long value) {
        Validate.notNull(value, "Bird id cant not be null");
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
