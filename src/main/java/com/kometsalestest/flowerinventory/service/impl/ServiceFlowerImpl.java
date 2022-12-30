package com.kometsalestest.flowerinventory.service.impl;

import com.kometsalestest.flowerinventory.dto.FlowerFullResponseDTO;
import com.kometsalestest.flowerinventory.dto.FlowerRequestDTO;
import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;
import com.kometsalestest.flowerinventory.entity.Flower;
import com.kometsalestest.flowerinventory.mapper.FlowerMapper;
import com.kometsalestest.flowerinventory.repository.IRepositoryFlower;
import com.kometsalestest.flowerinventory.service.IServiceFlower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceFlowerImpl implements IServiceFlower {

    @Autowired
    private IRepositoryFlower repositoryFlower;
    @Autowired
    private FlowerMapper flowerMapper;

    @Override
    public List<FlowerSmallResponseDTO> AllFlowers() {
        List<Flower> flowersRepo = repositoryFlower.findAll();
        List<FlowerSmallResponseDTO> flowers = new ArrayList<>();
        //flowersRepo.forEach(flower -> flowers.add(flowerMapper.entityToSmallDto(flower)) );
        for (Flower flower : flowersRepo) {
            flower.setName(flower.getName() + "-kometsales");
            flowers.add(flowerMapper.entityToSmallDto(flower));
        }
        return flowers;
    }

    @Override
    public List<FlowerFullResponseDTO> saveFlowers(List<FlowerRequestDTO> requestDTO) {
        List<FlowerFullResponseDTO> flowersResponse = new ArrayList<>();
        //requestDTO.forEach( flower -> repositoryFlower.save(flowerMapper.dtoToEntity(flower)) );
        for (FlowerRequestDTO flower : requestDTO) {
            repositoryFlower.save(flowerMapper.dtoToEntity(flower));
            flowersResponse.add(flowerMapper.requestToResponse(flower));
        }
        return flowersResponse;
    }

    public List<FlowerFullResponseDTO> priceFilter(Double price) {
        List<Flower> flowers = repositoryFlower.findByPrice(price);
        List<FlowerFullResponseDTO> flowersResponse = new ArrayList<>();
        flowers.forEach(flower -> flowersResponse.add(flowerMapper.entityToFullDto(flower)));
        return flowersResponse;
    }

    public List<FlowerFullResponseDTO> findByName(String name) {
        List<Flower> flowers = repositoryFlower.findByName(name);
        List<FlowerFullResponseDTO> fullResponseDTOS = new ArrayList<>();
        flowers.forEach( flower -> fullResponseDTOS.add(flowerMapper.entityToFullDto(flower)) );
        return fullResponseDTOS;
    }

    @Override
    public Map<String, String> deleteFlowerById(Long id) {
        Flower flowerToDelete = repositoryFlower.findById(id).orElseThrow( ()-> new RuntimeException("Flower id not found") );
        repositoryFlower.deleteById(flowerToDelete.getId());
        Map<String, String> message = new HashMap<>();
        message.put("message", "Flower deleted successful");
        return message;
    }
}
