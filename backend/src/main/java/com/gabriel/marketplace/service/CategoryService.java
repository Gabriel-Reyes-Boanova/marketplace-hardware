package com.gabriel.marketplace.service;

import com.gabriel.marketplace.entity.Category;
import com.gabriel.marketplace.exception.CategoryNotFindException;
import com.gabriel.marketplace.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.gabriel.marketplace.dto.CategoryDTO.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private CategoryRepository repository;

    public List<CategoryResponse> findAllCategories() {
        return repository.findAll()
                .stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .title(category.getTitle())
                        .description(category.getDescription())
                        .createdAt(category.getCreatedAt())
                        .build())
                .toList();
    }

    public CategoryResponse findCategoryByTitle(String title){
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException(
                    "O título não pode estar vazio"
            );
        }

        Category category = repository.findByTitle(title.trim().toLowerCase())
                .orElseThrow(() -> new CategoryNotFindException(
                        "A categoria não foi encontrada"
                ));

        return CategoryResponse.builder()
                .id(category.getId())
                .title(category.getTitle())
                .description(category.getDescription())
                .createdAt(category.getCreatedAt())
                .build();
    }
}
