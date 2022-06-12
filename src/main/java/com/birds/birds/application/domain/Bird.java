package com.birds.birds.application.domain;

import com.birds.birds.application.domain.valueObjects.*;

public class Bird {
    private final BirdId birdId;
    private final CommonName commonName;
    private final ScientificName scientificName;
    private final ZoneName zoneName;
    private final ConfirmedQuantity confirmedQuantity;

    public Bird(BirdId birdId, CommonName commonName, ScientificName scientificName, ZoneName zoneName, ConfirmedQuantity confirmedQuantity) {
        this.birdId = birdId;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
        this.confirmedQuantity = confirmedQuantity;
    }

    public BirdId getBirdId() {
        return birdId;
    }

    public CommonName getCommonName() {
        return commonName;
    }

    public ScientificName getScientificName() {
        return scientificName;
    }

    public ZoneName getZoneName() {
        return zoneName;
    }

    public ConfirmedQuantity getConfirmedQuantity() {
        return confirmedQuantity;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "birdId=" + birdId +
                ", commonName=" + commonName +
                ", scientificName=" + scientificName +
                ", zoneName=" + zoneName +
                ", confirmedQuantity=" + confirmedQuantity +
                '}';
    }
}
