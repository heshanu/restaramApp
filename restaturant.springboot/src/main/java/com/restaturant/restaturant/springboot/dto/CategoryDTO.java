package com.restaturant.restaturant.springboot.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CategoryDTO {
    private Long id;
    private String description;
    private String name;
    private MultipartFile img;
    private byte[] returnImg;
}
