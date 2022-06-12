package com.birds.birds.domain.valueObjects;

import com.birds.application.domain.valueObjects.BirdId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BirdIdTest {
    @Test
    @DisplayName("Null bird id should throw an error")
    void null_bird_ir(){
        Long invalidId = null;

        assertThrows(NullPointerException.class, () -> {
           new BirdId(invalidId);
        });
    }

    @Test
    @DisplayName("valid bird id should no throw an error")
    void valid_bird_id(){
        Long valid = 1L;

        assertDoesNotThrow(() ->{
            new BirdId(valid);
        });
    }
}
