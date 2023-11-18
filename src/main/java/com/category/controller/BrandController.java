package com.category.controller;

import com.category.model.dto.command.BrandAddCommand;
import com.category.model.dto.command.BrandModifyCommand;
import com.category.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/brand")
public class BrandController {

    private final BrandService brandService;

    @PostMapping("")
    public ResponseEntity<Long> createBrand(
            @RequestBody BrandAddCommand addCommand
    ) {
        return ResponseEntity.ok()
                .body(brandService.createBrand(addCommand));
    }

    @PutMapping("/{brandNo}")
    public ResponseEntity<Boolean> modifyBrand(
            @PathVariable long brandNo,
            @RequestBody BrandModifyCommand modifyCommand
    ) {
        return ResponseEntity.ok()
                .body(brandService.modifyBrand(brandNo, modifyCommand));
    }

    @DeleteMapping("/{brandNo}")
    public ResponseEntity<Boolean> deleteBrand(
            @PathVariable long brandNo
    ) {
        return ResponseEntity.ok()
                .body(brandService.deleteBrand(brandNo));
    }
}