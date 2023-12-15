package com.restaturant.restaturant.springboot.service.admin;

import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<CategoryDTO> postCategory(CategoryDTO categoryDTO);
}
