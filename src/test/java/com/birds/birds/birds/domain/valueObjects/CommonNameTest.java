package com.birds.birds.birds.domain.valueObjects;

import com.birds.birds.application.domain.valueObjects.CommonName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommonNameTest {
    @Test
    @DisplayName("null common name should throw an error")
    void null_common_name(){
        String invalid = null;

        assertThrows(NullPointerException.class, () ->{
           new CommonName(invalid);
        });
    }

    @Test
    @DisplayName("Length bird common name should throw an error")
    void length_invalid_common_name(){
        String responseMessage = "Bird common name can not be longer then 30 characters";
        String invalidCommonName = "descripcion superior a los 30 caracteres permitidos";

        try{
            new CommonName(invalidCommonName);
        }catch (Exception exception){
            assertEquals(responseMessage, exception.getMessage());
        }
    }

    @Test
    @DisplayName("Valid length, type and result")
    void valid_common_name(){
        String validCommonName = "pinche";

        CommonName result = new CommonName(validCommonName);

        assertInstanceOf(CommonName.class, result);
        assertEquals(validCommonName, result.getValue());
        assertTrue(validCommonName.length() <= 30);
    }
}
