package com.kometsalestest.flowerinventory.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "t_flowers")
@Data
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
}
