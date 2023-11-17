package com.category.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    @GetMapping("/category/brand/minPrice")
    public String getMinPriceGoodsByCategoryPage(Model model) {
        return "category/minPrice";
    }
}