package com.category.controller;

import com.category.model.dto.request.ProductAddRequest;
import com.category.model.dto.request.ProductModifyRequest;
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
            @RequestBody ProductAddRequest addRequest
    ) {
        return ResponseEntity.ok(
                productService.createProduct(addRequest)
        );
    }

    @PutMapping("/{productNo}")
    public ResponseEntity<Boolean> modifyProduct(
            @PathVariable long productNo,
            @RequestBody ProductModifyRequest modifyRequest
    ) {
        return ResponseEntity.ok(
                productService.modifyProduct(productNo, modifyRequest)
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