package com.birds.birds.application.ports.output;

import com.birds.birds.application.domain.Bird;
import com.birds.birds.application.domain.valueObjects.BirdId;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BirdRepository {
    void store(Bird bird);
    Optional<Bird> get(BirdId birdId);
    void update(Bird bird);
    boolean delete(BirdId birdId);
}
