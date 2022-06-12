package com.birds.birds.birds.domain;

import com.birds.birds.application.domain.Bird;
import com.birds.birds.application.domain.valueObjects.*;

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
    }
}
