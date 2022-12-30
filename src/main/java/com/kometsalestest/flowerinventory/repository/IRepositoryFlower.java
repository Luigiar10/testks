package com.kometsalestest.flowerinventory.repository;

import com.kometsalestest.flowerinventory.entity.Flower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepositoryFlower extends JpaRepository<Flower, Long> {
    List<Flower> findByName(String name);
    @Query("SELECT u FROM Flower u WHERE u.price >= :price")
    List<Flower> findByPrice(Double price);
}
