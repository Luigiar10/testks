package com.kometsalestest.flowerinventory.controller;

import com.kometsalestest.flowerinventory.dto.FlowerFullResponseDTO;
import com.kometsalestest.flowerinventory.dto.FlowerRequestDTO;
import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;
import com.kometsalestest.flowerinventory.service.impl.ServiceFlowerImpl;
import jakarta.websocket.server.PathParam;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flowers")
@Slf4j
public class FlowerController {

    @Autowired
    private ServiceFlowerImpl serviceFlower;

    @GetMapping
    public ResponseEntity<List<FlowerSmallResponseDTO>> getAllFlowers() {
        log.info("Call get mapping /flowers");
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.AllFlowers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<List<FlowerFullResponseDTO>> saveListFlowers(@RequestBody List<FlowerRequestDTO> requestDTOS) {
        log.info("Call post mapping /flowers");
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.saveFlowers(requestDTOS), HttpStatus.CREATED);
    }

    @GetMapping(
            params = "name"
    )
    public ResponseEntity<List<FlowerFullResponseDTO>> flowersByName(@RequestParam String name) {
        log.info("Call get mapping /flowers?name={}", name);
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.findByName(name), HttpStatus.OK);
    }

    @GetMapping(
            params = "price"
    )
    public ResponseEntity<List<FlowerFullResponseDTO>> filterPrice(@RequestParam Double price) {
        log.info("Call get mapping /flowers?price={}", price);
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.priceFilter(price), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteFlower(@PathVariable Long id) {
        log.info("Call delete mapping /flowers/{}", id);
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.deleteFlowerById(id), HttpStatus.ACCEPTED);
    }

}
