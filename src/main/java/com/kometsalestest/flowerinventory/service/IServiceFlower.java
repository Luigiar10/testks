package com.kometsalestest.flowerinventory.service;

import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;
import com.kometsalestest.flowerinventory.entity.Flower;

import java.util.List;
import java.util.Map;

public interface IServiceFlower {
    List<Flower> saveFlowers(List<Flower> requestDTO);
    List<FlowerSmallResponseDTO> AllFlowers();
    List<Flower> priceFilter(Double price);
    Map<String, String> deleteFlowerById(Long id);
    List<Flower> nameFilter(String name);
}
