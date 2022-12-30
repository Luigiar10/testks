package com.kometsalestest.flowerinventory.mapper;

import com.kometsalestest.flowerinventory.dto.FlowerFullResponseDTO;
import com.kometsalestest.flowerinventory.dto.FlowerRequestDTO;
import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;
import com.kometsalestest.flowerinventory.entity.Flower;
import org.springframework.stereotype.Component;

@Component
public class FlowerMapper {

    public FlowerFullResponseDTO entityToFullDto(Flower flower) {
        FlowerFullResponseDTO fullResponse = new FlowerFullResponseDTO();
        fullResponse.setId(flower.getId());
        fullResponse.setName(flower.getName());
        fullResponse.setPrice(flower.getPrice());
        return fullResponse;
    }

    public FlowerSmallResponseDTO entityToSmallDto(Flower flower) {
        FlowerSmallResponseDTO smallResponse = new FlowerSmallResponseDTO();
        smallResponse.setName(flower.getName());
        smallResponse.setPrice(flower.getPrice());
        return smallResponse;
    }

    public Flower dtoToEntity(FlowerRequestDTO requestDTO) {
        Flower flower = new Flower();
        flower.setId(requestDTO.getId());
        flower.setName(requestDTO.getName());
        flower.setPrice(requestDTO.getPrice());
        return flower;
    }

    public FlowerFullResponseDTO requestToResponse(FlowerRequestDTO requestDTO) {
        FlowerFullResponseDTO fullResponseDTO = new FlowerFullResponseDTO();
        fullResponseDTO.setId(requestDTO.getId());
        fullResponseDTO.setName(requestDTO.getName());
        fullResponseDTO.setPrice(requestDTO.getPrice());
        return fullResponseDTO;
    }

}
