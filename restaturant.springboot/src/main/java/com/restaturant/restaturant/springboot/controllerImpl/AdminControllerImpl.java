package com.restaturant.restaturant.springboot.controllerImpl;

import com.restaturant.restaturant.springboot.controller.AdminController;
import com.restaturant.restaturant.springboot.dto.CategoryDTO;
import com.restaturant.restaturant.springboot.service.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {
    @Autowired
    private AdminService adminService;
    @Override
    public ResponseEntity<CategoryDTO> postCategory(CategoryDTO categoryDTO) {
        try{
            return adminService.postCategory(categoryDTO);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.badRequest().build();
    }
}
