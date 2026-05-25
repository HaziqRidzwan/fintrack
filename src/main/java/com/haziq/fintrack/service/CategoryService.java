package com.haziq.fintrack.service;

import com.haziq.fintrack.entity.Category;
import com.haziq.fintrack.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void save(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void deleteById(Long id){
        categoryRepository.deleteById(id);
    }
}
