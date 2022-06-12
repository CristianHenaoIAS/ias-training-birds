package com.birds.birds.domain.valueObjects;

import com.birds.application.domain.valueObjects.ConfirmedQuantity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConfirmedQuantityTest {

    @Test
    @DisplayName("Null confirmed quantity should throw an error")
    void null_confirmed_quantity(){
        Integer invalid = null;

        assertThrows(NullPointerException.class, () ->{
           new ConfirmedQuantity(invalid);
        });
    }

    @Test
    @DisplayName("invalid length confirmed quantity")
    void invalid_confirmed_quantity(){
        String responseMessage = "confirmed quantity only allows values between 1 and 100000";
        Integer invalid = 1000000;

        try{
            new ConfirmedQuantity(invalid);
        }catch (Exception exception){
            assertEquals(responseMessage, exception.getMessage());
        }

    }

    @Test
    @DisplayName("Valid length, type and result")
    void valid_confirmed_quantity(){
        Integer valid = 100000;

        ConfirmedQuantity result = new ConfirmedQuantity(valid);

        assertInstanceOf(ConfirmedQuantity.class, result);
        assertEquals(valid, result.getValue());
    }
}
