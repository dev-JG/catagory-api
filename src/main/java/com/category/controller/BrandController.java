package com.category.controller;

import com.category.model.dto.request.BrandAddRequest;
import com.category.model.dto.request.BrandModifyRequest;
import com.category.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/brand")
public class BrandController {

    private final BrandService brandService;

    @PostMapping("")
    public ResponseEntity<Long> createBrand(
            @RequestBody BrandAddRequest addRequest
    ) {
        return ResponseEntity.ok(
                brandService.createBrand(addRequest)
        );
    }

    @PutMapping("/{brandNo}")
    public ResponseEntity<Boolean> modifyBrand(
            @PathVariable long brandNo,
            @RequestBody BrandModifyRequest modifyRequest
    ) {
        return ResponseEntity.ok(
                brandService.modifyBrand(brandNo, modifyRequest)
        );
    }

    @DeleteMapping("/{brandNo}")
    public ResponseEntity<Boolean> deleteBrand(
            @PathVariable long brandNo
    ) {
        return ResponseEntity.ok(
                brandService.deleteBrand(brandNo)
        );
    }
}