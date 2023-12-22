package com.restaturant.restaturant.springboot.service.admin;

import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import com.restaturant.restaturant.springboot.entity.CategoryEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    ResponseEntity<CategoryDTO> postCategory(CategoryDTO categoryDTO);


    List<CategoryEntity> getCategories();
}
