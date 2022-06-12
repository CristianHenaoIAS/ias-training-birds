package com.birds.application.services;

import com.birds.application.domain.Bird;
import com.birds.application.ports.input.UpdateBirdByIdUseCase;
import com.birds.application.ports.output.BirdRepository;
import com.birds.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBirdService implements UpdateBirdByIdUseCase {
    private final BirdRepository birdRepository;

    public UpdateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {
        Bird bird = birdDTO.toDomain();

        Optional<Bird> birdBD = birdRepository.get(bird.getBirdId());

        if(birdBD.isPresent()){
            birdRepository.update(bird);
            birdDTO.setStatus("Bird Updated");
        }
        else
            birdDTO.setStatus("Bird no Updated");

        return birdDTO;
    }
}
