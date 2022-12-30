package com.kometsalestest.flowerinventory.controller;

import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;
import com.kometsalestest.flowerinventory.entity.Flower;
import com.kometsalestest.flowerinventory.service.impl.ServiceFlowerImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public ResponseEntity<List<Flower>> saveListFlowers(@RequestBody List<Flower> requestDTOS) {
        log.info("Call post mapping /flowers");
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.saveFlowers(requestDTOS), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FlowerSmallResponseDTO>> getAllFlowers() {
        log.info("Call get mapping /flowers");
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.AllFlowers(), HttpStatus.OK);
    }

    @GetMapping(
            params = "price"
    )
    public ResponseEntity<List<Flower>> priceFilter(@RequestParam Double price) {
        return new ResponseEntity<>(serviceFlower.priceFilter(price), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteFlower(@PathVariable Long id) {
        log.info("Call delete mapping /flowers/{}", id);
        log.info("---------------------------------");
        return new ResponseEntity<>(serviceFlower.deleteFlowerById(id), HttpStatus.OK);
    }

    @GetMapping(
            params = "name"
    )
    public ResponseEntity<List<Flower>> nameFilter(@RequestParam String name) {
        return new ResponseEntity<>(serviceFlower.nameFilter(name), HttpStatus.OK);
    }

}
