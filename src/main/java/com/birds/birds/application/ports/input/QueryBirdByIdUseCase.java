package com.birds.birds.application.ports.input;

import com.birds.birds.commons.UseCase;
import com.birds.birds.infrastructure.models.BirdDTO;

import java.util.Optional;

public interface QueryBirdByIdUseCase extends UseCase<Long, Optional<BirdDTO>> {
}
