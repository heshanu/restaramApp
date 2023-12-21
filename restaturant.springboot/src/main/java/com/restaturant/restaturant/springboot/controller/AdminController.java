package com.restaturant.restaturant.springboot.controller;

import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/admin")
public interface AdminController {
    @PostMapping("/category")
    public ResponseEntity<CategoryDTO> postCategory(@RequestBody CategoryDTO categoryDTO);

}
