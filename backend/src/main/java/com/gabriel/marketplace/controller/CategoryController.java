package com.gabriel.marketplace.controller;

import com.gabriel.marketplace.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.gabriel.marketplace.dto.CategoryDTO.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAllCategories() {
        return ResponseEntity.ok(service.findAllCategories());
    }

    @GetMapping("/{title}")
    public ResponseEntity<CategoryResponse> findCategoryById(@PathVariable String title) {
        return ResponseEntity.ok(service.findCategoryByTitle(title));
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody @Validated CategoryRequest request){
        CategoryResponse response = service.createCategory(request);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }
}
