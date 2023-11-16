package com.category.controller;

import com.category.model.dto.request.ProductAddCommand;
import com.category.model.dto.request.ProductModifyCommand;
import com.category.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    public ResponseEntity<Long> createProduct(
            @RequestBody ProductAddCommand addCommand
    ) {
        return ResponseEntity.ok(
                productService.createProduct(addCommand)
        );
    }

    @PutMapping("/{productNo}")
    public ResponseEntity<Boolean> modifyProduct(
            @PathVariable long productNo,
            @RequestBody ProductModifyCommand modifyCommand
    ) {
        return ResponseEntity.ok(
                productService.modifyProduct(productNo, modifyCommand)
        );
    }

    @DeleteMapping("/{productNo}")
    public ResponseEntity<Boolean> deleteProduct(
            @PathVariable long productNo
    ) {
        return ResponseEntity.ok(
                productService.deleteProduct(productNo)
        );
    }
}