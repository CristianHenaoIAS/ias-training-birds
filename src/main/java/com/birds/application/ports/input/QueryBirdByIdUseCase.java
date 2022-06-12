package com.birds.application.ports.input;

import com.birds.commons.UseCase;
import com.birds.infrastructure.models.BirdDTO;

import java.util.Optional;

public interface QueryBirdByIdUseCase extends UseCase<Long, Optional<BirdDTO>> {
}
