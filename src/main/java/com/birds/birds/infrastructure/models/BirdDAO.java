package com.birds.birds.infrastructure.models;

import com.birds.birds.application.domain.Bird;
import com.birds.birds.application.domain.valueObjects.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BirdDAO {
    private Long birdId;
    private String commonName;
    private Integer confirmedQuantity;
    private String scientificName;
    private String zoneName;

    public BirdDAO() {
    }

    public BirdDAO(Long birdId, String commonName, Integer confirmedQuantity, String scientificName, String zoneName) {
        this.birdId = birdId;
        this.commonName = commonName;
        this.confirmedQuantity = confirmedQuantity;
        this.scientificName = scientificName;
        this.zoneName = zoneName;
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

    public BirdDTO fromDomain(Bird bird){
        BirdDTO birdDTO = new BirdDTO();
        birdDTO.setBirdId(bird.getBirdId().getValue());
        birdDTO.setCommonName(bird.getCommonName().getValue());
        birdDTO.setConfirmedQuantity(bird.getConfirmedQuantity().getValue());
        birdDTO.setZoneName(bird.getZoneName().getValue());
        birdDTO.setScientificName(bird.getScientificName().getValue());

        return birdDTO;
    }

    public static BirdDAO fromResultSet(ResultSet resultSet) throws SQLException {
        BirdDAO birdDAO = new BirdDAO();
        birdDAO.setBirdId(resultSet.getLong("id"));
        birdDAO.setCommonName(resultSet.getString("common_name"));
        birdDAO.setConfirmedQuantity(resultSet.getInt("confirmed_quantity"));
        birdDAO.setScientificName(resultSet.getString("scientific_name"));
        birdDAO.setZoneName(resultSet.getString("zone_name"));

        return  birdDAO;
    }
}
