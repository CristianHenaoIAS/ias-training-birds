package com.birds.application.services;

import com.birds.application.domain.Bird;
import com.birds.application.domain.valueObjects.CommonName;
import com.birds.application.domain.valueObjects.ConfirmedQuantity;
import com.birds.application.domain.valueObjects.ScientificName;
import com.birds.application.domain.valueObjects.ZoneName;
import com.birds.application.ports.input.CreateBirdUseCase;
import com.birds.application.ports.output.BirdRepository;
import com.birds.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateBirdService implements CreateBirdUseCase {
    private final BirdRepository birdRepository;

    public CreateBirdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public BirdDTO execute(BirdDTO birdDTO) {
        Bird bird = new Bird(null,
                new CommonName(birdDTO.getCommonName()),
                new ScientificName(birdDTO.getScientificName()),
                new ZoneName(birdDTO.getZoneName()),
                new ConfirmedQuantity(birdDTO.getConfirmedQuantity()));

        birdRepository.store(bird);
        birdDTO.setStatus("Bird Created");

        return birdDTO;
    }
}
