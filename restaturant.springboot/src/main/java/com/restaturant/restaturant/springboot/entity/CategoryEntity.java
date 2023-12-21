package com.restaturant.restaturant.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private String name;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] img;
}
