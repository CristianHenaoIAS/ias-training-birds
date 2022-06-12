package com.birds.infrastructure.controllers;

import com.birds.application.ports.input.CreateBirdUseCase;
import com.birds.application.ports.input.DeleteBirdUseCase;
import com.birds.application.ports.input.QueryBirdByIdUseCase;
import com.birds.application.ports.input.UpdateBirdByIdUseCase;
import com.birds.infrastructure.models.ApplicationError;
import com.birds.infrastructure.models.BirdDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
import java.util.Optional;

@Controller
public class BirdController {
    private final CreateBirdUseCase createBirdUseCase;
    private final QueryBirdByIdUseCase queryBirdByIdUseCase;
    private final UpdateBirdByIdUseCase updateBirdByIdUseCase;
    private final DeleteBirdUseCase deleteBirdUseCase;

    public BirdController(CreateBirdUseCase createBirdUseCase, QueryBirdByIdUseCase queryBirdByIdUseCase, UpdateBirdByIdUseCase birdByIdUseCase, DeleteBirdUseCase deleteBirdUseCase) {
        this.createBirdUseCase = createBirdUseCase;
        this.queryBirdByIdUseCase = queryBirdByIdUseCase;
        this.updateBirdByIdUseCase = birdByIdUseCase;
        this.deleteBirdUseCase = deleteBirdUseCase;
    }

    @RequestMapping(value = "/birds", method = RequestMethod.POST)
    public ResponseEntity<?> createBird(@RequestBody BirdDTO birdDTO){
        try{
            BirdDTO birdDTOOutput = createBirdUseCase.execute(birdDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(birdDTOOutput);
        }catch(IllegalArgumentException | NullPointerException e){
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data", Map.of("error", e.getMessage()));
            return ResponseEntity.badRequest().body(applicationError);
        }catch (Exception e){
            ApplicationError applicationError = new ApplicationError("System error", "Try more later", Map.of());
            System.out.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }

    }
    @RequestMapping(value = "/birds/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
        try {
            Optional<BirdDTO> birdDTOOptional = queryBirdByIdUseCase.execute(id);
            if (birdDTOOptional.isPresent()) {
                return ResponseEntity.ok(birdDTOOptional.get());
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No exist bird with this id");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }

    }

    @RequestMapping(value = "/birds", method = RequestMethod.PUT)
    public ResponseEntity<?> updateProduct(@RequestBody BirdDTO productDTO) {
        try {
            BirdDTO birdDTOOutput = updateBirdByIdUseCase.execute(productDTO);
            return ResponseEntity.ok(birdDTOOutput);
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }

    @RequestMapping(value="/birds/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        try {
            Boolean result = deleteBirdUseCase.execute(id);
            if (result) {
                return ResponseEntity.ok("Bird removed successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bird can not be deleted");
            }
        } catch (NullPointerException | IllegalArgumentException exception) {
            ApplicationError applicationError = new ApplicationError("InputDataValidationError", "Bad input data",
                    Map.of("error", exception.getMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(applicationError);
        } catch (Exception exception) {
            ApplicationError applicationError = new ApplicationError("SystemError", "Try more later", Map.of());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(applicationError);
        }
    }
}
