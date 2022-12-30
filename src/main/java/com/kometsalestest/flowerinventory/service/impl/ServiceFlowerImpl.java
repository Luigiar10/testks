package com.kometsalestest.flowerinventory.service.impl;

import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;
import com.kometsalestest.flowerinventory.entity.Flower;
import com.kometsalestest.flowerinventory.mapper.FlowerMapper;
import com.kometsalestest.flowerinventory.service.IServiceFlower;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ServiceFlowerImpl implements IServiceFlower {

    private static List<Flower> flowersData = new ArrayList<>();

    @Autowired
    private FlowerMapper flowerMapper;

    @Override
    public List<Flower> saveFlowers(List<Flower> requestDTO) {
        flowersData = requestDTO;
        return flowersData;
    }

    @Override
    public List<FlowerSmallResponseDTO> AllFlowers() {
        List<FlowerSmallResponseDTO> smallResponseDTOS = new ArrayList<>();
        //flowersData.forEach(flower -> smallResponseDTOS.add(flowerMapper.entityToSmallDto(flower)));
        for (Flower flower : flowersData) {
            flower.setName(flower.getName()+"-kometsales");
            smallResponseDTOS.add(flowerMapper.entityToSmallDto(flower));
        }
        return smallResponseDTOS;
    }

    @Override
    public List<Flower> priceFilter(Double price) {
        return flowersData.stream().filter( flower -> flower.getPrice() >= price ).collect(Collectors.toList());
    }

    @Override
    public Map<String, String> deleteFlowerById(Long id) {
        Flower flowerToDelete = flowersData.stream().filter( flower -> flower.getId().equals(id)).findAny().orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found Flower") );
        flowersData.remove(flowerToDelete);
        Map<String, String> message = new HashMap<>();
        message.put("message", "Flower Deleted successful");
        return message;
    }

    @Override
    public List<Flower> nameFilter(String name) {
        return flowersData.stream().filter( flower -> flower.getName().equals(name)).collect(Collectors.toList());
    }

}
