package com.haziq.fintrack.controller;

import com.haziq.fintrack.entity.Category;
import com.haziq.fintrack.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController (CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String getCategories (Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories";
    }

    @PostMapping("/categories/save")
    public RedirectView saveCategories(@ModelAttribute Category category){
        categoryService.save(category);
        return new RedirectView("/categories");
    }

    @GetMapping("/categories/delete/{id}")
    public RedirectView deleteCategories(@PathVariable Long id){
        categoryService.deleteById(id);
        return new RedirectView("/categories");
    }
}
