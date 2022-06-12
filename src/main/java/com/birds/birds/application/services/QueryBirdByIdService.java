package com.birds.birds.application.services;

import com.birds.birds.application.domain.Bird;
import com.birds.birds.application.domain.valueObjects.BirdId;
import com.birds.birds.application.ports.input.QueryBirdByIdUseCase;
import com.birds.birds.application.ports.output.BirdRepository;
import com.birds.birds.infrastructure.models.BirdDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QueryBirdByIdService implements QueryBirdByIdUseCase {
    private final BirdRepository birdRepository;

    public QueryBirdByIdService(BirdRepository birdRepository) {
        this.birdRepository = birdRepository;
    }

    @Override
    public Optional<BirdDTO> execute(Long id) {

        Optional<Bird> birdOptional = birdRepository.get(new BirdId(id));

        return birdOptional.map(bird ->{
           BirdDTO birdDTO = BirdDTO.fromDomain(bird);

           return birdDTO;
        });
    }
}
