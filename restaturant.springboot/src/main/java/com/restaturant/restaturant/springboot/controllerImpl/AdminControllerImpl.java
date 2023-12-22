package com.restaturant.restaturant.springboot.controllerImpl;

import com.restaturant.restaturant.springboot.controller.AdminController;
import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import com.restaturant.restaturant.springboot.entity.CategoryEntity;
import com.restaturant.restaturant.springboot.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {
    @Autowired
    private AdminService adminService;
    @Override
    public ResponseEntity<CategoryDTO> postCategory(CategoryDTO categoryDTO) {

        try{
            if(Objects.isNull(categoryDTO)){
                return ResponseEntity.badRequest().build();
            }
            return adminService.postCategory(categoryDTO);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<List<CategoryEntity>> getCategory() {
        try{
            if(Objects.isNull(adminService.getCategories())){
                return ResponseEntity.notFound().build();
            }
           List<CategoryEntity> categoryDTOList= adminService.getCategories();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
}
