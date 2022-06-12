package com.birds.infrastructure.models;

import com.birds.application.domain.Bird;
import com.birds.application.domain.valueObjects.*;

public class BirdDTO {
    private Long birdId;
    private String commonName;
    private Integer confirmedQuantity;
    private String scientificName;
    private String zoneName;
    private String status;

    public BirdDTO() {
    }

    public BirdDTO(Long birdId, String commonName, Integer confirmedQuantity, String scientificName, String zoneName, String status) {
        this.birdId = birdId;
        this.commonName = commonName;
        this.confirmedQuantity = confirmedQuantity;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBirdId() {
        return birdId;
    }

    public void setBirdId(Long birdId) {
        this.birdId = birdId;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public Integer getConfirmedQuantity() {
        return confirmedQuantity;
    }

    public void setConfirmedQuantity(Integer confirmedQuantity) {
        this.confirmedQuantity = confirmedQuantity;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Bird toDomain(){
        return new Bird(
                new BirdId(birdId),
                new CommonName(commonName),
                new ScientificName(scientificName),
                new ZoneName(zoneName),
                new ConfirmedQuantity(confirmedQuantity)

        );
    }

    public static BirdDTO fromDomain(Bird bird){
        BirdDTO birdDTO = new BirdDTO();
        birdDTO.setBirdId(bird.getBirdId().getValue());
        birdDTO.setCommonName(bird.getCommonName().getValue());
        birdDTO.setConfirmedQuantity(bird.getConfirmedQuantity().getValue());
        birdDTO.setZoneName(bird.getZoneName().getValue());
        birdDTO.setScientificName(bird.getScientificName().getValue());

        return birdDTO;
    }
}
