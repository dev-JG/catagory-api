package com.category.controller;

import com.category.model.dto.command.GoodsAddCommand;
import com.category.model.dto.command.GoodsModifyCommand;
import com.category.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/goods")
public class GoodsController {

    private final GoodsService goodsService;

    @PostMapping("")
    public ResponseEntity<Long> createGoodsNo(
            @RequestBody GoodsAddCommand addCommand
    ) {
        return ResponseEntity.ok(
                goodsService.createGoods(addCommand)
        );
    }

    @PutMapping("/{goodsNo}")
    public ResponseEntity<Boolean> modifyGoodsNo(
            @PathVariable long goodsNo,
            @RequestBody GoodsModifyCommand modifyCommand
    ) {
        return ResponseEntity.ok(
                goodsService.modifyGoods(goodsNo, modifyCommand)
        );
    }

    @DeleteMapping("/{goodsNo}")
    public ResponseEntity<Boolean> deleteGoodsNo(
            @PathVariable long goodsNo
    ) {
        return ResponseEntity.ok(
                goodsService.deleteGoods(goodsNo)
        );
    }
}