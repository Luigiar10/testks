package com.kometsalestest.flowerinventory.mapper;

import com.kometsalestest.flowerinventory.dto.FlowerSmallResponseDTO;
import com.kometsalestest.flowerinventory.entity.Flower;
import org.springframework.stereotype.Component;

@Component
public class FlowerMapper {

    public FlowerSmallResponseDTO entityToSmallDto(Flower flower) {
        FlowerSmallResponseDTO smallResponse = new FlowerSmallResponseDTO();
        smallResponse.setName(flower.getName());
        smallResponse.setPrice(flower.getPrice());
        return smallResponse;
    }

}
