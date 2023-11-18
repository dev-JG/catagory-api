package com.category.controller.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class UiController {

    @GetMapping("/category/brand/minPrice")
    public String getMinPriceGoodsByCategoryPage(Model model) {
        String now = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
        model.addAttribute("now", now);

        return "category/minPrice";
    }
}