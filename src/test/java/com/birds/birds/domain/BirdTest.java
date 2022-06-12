package com.birds.birds.domain;

import com.birds.application.domain.Bird;
import com.birds.application.domain.valueObjects.*;
import com.birds.infrastructure.models.BirdDTO;

public class BirdTest {
    public static void main(String[] args){
        try{
            Bird bird = new Bird(
                    new BirdId(1L),
                    new CommonName("prueba"),
                    new ScientificName("prueba nombre cientifico"),
                    new ZoneName("prueba nombre de la zona"),
                    new ConfirmedQuantity(100000)
            );
        }catch (NullPointerException | IllegalArgumentException exception){
            System.out.println(exception.getMessage());
        }

        BirdDTO birdDTO = new BirdDTO(1L, "nombre comun", 300, "Nombre cientifico", "zona", null);

        Bird bird = birdDTO.toDomain();
        System.out.println("dto example" + bird);

        BirdDTO birdDTO1 = BirdDTO.fromDomain(bird);
        System.out.println("from domain" + birdDTO1);
    }
}
