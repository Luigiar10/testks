package com.kometsalestest.flowerinventory.service;

import com.kometsalestest.flowerinventory.dto.FlowerFullResponseDTO;
import com.kometsalestest.flowerinventory.dto.FlowerRequestDTO;
import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;

import java.util.List;
import java.util.Map;

public interface IServiceFlower {
    List<FlowerSmallResponseDTO> AllFlowers();
    List<FlowerFullResponseDTO> saveFlowers(List<FlowerRequestDTO> requestDTO);
    Map<String, String> deleteFlowerById(Long id);
}
