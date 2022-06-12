package com.birds.birds.commons;

public interface UseCase<Input, Output> {
    Output execute(Input input);
}
