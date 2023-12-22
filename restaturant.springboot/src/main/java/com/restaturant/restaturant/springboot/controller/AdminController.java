package com.restaturant.restaturant.springboot.controller;

import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import com.restaturant.restaturant.springboot.entity.CategoryEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/admin")
public interface AdminController {
    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> postCategory(@ModelAttribute CategoryDTO categoryDTO);

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryEntity>> getCategory();

}
