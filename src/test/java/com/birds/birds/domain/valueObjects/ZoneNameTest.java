package com.birds.birds.domain.valueObjects;

import com.birds.application.domain.valueObjects.ZoneName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ZoneNameTest {
    @Test
    @DisplayName("null zone name should throw an error")
    void null_scientific_name(){
        // AAA - arrange act assert
        String invalid = null;

        assertThrows(NullPointerException.class, () ->{
            new ZoneName(invalid);
        });
    }

    @Test
    @DisplayName("Length zone name should throw an error")
    void length_invalid_zone_name(){
        // AAA - arrange act assert
        String responseMessage = "Bird zone name can not be longer then 20 characters";
        String invalidZoneName = "Descripcion superior a los 20 caracteres para validar la prueba";

        try{
            new ZoneName(invalidZoneName);
        }catch (Exception exception){
            assertEquals(responseMessage, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valid length, type and result")
    void valid_zone_name(){
        String validZoneName = "Antioquia";

        ZoneName result = new ZoneName(validZoneName);

        assertInstanceOf(ZoneName.class, result);
        assertEquals(validZoneName, result.getValue());
        assertTrue(validZoneName.length() <= 30);
    }
}
