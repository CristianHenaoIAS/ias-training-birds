package com.birds.application.services;

import com.birds.application.domain.Bird;
import com.birds.application.domain.valueObjects.BirdId;
import com.birds.application.ports.input.QueryBirdByIdUseCase;
import com.birds.application.ports.output.BirdRepository;
import com.birds.infrastructure.models.BirdDTO;
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
