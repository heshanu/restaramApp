package com.restaturant.restaturant.springboot.serviceImpl;

import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import com.restaturant.restaturant.springboot.entity.CategoryEntity;
import com.restaturant.restaturant.springboot.repo.CategoryRepo;
import com.restaturant.restaturant.springboot.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public ResponseEntity<CategoryDTO> postCategory(CategoryDTO categoryDTO){
        try{
            CategoryEntity category = new CategoryEntity();
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            category.setImg(categoryDTO.getImg().getBytes());
            categoryRepo.save(category);

            CategoryDTO catDTO = new CategoryDTO();
            catDTO.setId(category.getId());

            return ResponseEntity.ok(categoryDTO);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
