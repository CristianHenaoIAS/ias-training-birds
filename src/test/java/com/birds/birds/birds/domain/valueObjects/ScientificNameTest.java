package com.birds.birds.birds.domain.valueObjects;
import com.birds.birds.application.domain.valueObjects.ScientificName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ScientificNameTest {
    @Test
    @DisplayName("null Scientific Name should throw an error")
    void null_scientific_name(){
        String invalid = null;

        assertThrows(NullPointerException.class, () ->{
            new ScientificName(invalid);
        });
    }

    @Test
    @DisplayName("Length bird scientific name should throw an error")
    void length_invalid_scientific_name(){
        String responseMessage = "Bird scientific name can not be longer then 30 characters";
        String invalidScientificName = "descripcion superior a los 30 caracteres permitidos";
        try{
            new ScientificName(invalidScientificName);
        }catch (Exception exception){
            assertEquals(responseMessage, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valid length, type and result")
    void valid_scientific_name(){
        String validScientificName = "Zonotrichia capensis";

        ScientificName result = new ScientificName(validScientificName);

        assertInstanceOf(ScientificName.class, result);
        assertEquals(validScientificName, result.getValue());
        assertTrue(validScientificName.length() <= 30);
    }
}
