package com.restaturant.restaturant.springboot.entity;

import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

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
    @Column(columnDefinition = "longblob")
    private byte[] img;

    public CategoryEntity() {
    }


}
