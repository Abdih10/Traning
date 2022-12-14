package com.example.consid.rest;

import com.example.consid.models.dto.creation.CategoryCreationDto;
import com.example.consid.models.dto.response.CategoryDto;
import com.example.consid.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/category")
@RequestMapping
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /**
     * Find a list of all categories
     *
     * @return list
     */
    @GetMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CategoryDto> allCategories() {
        return categoryService.findAllCategories();
    }

    /**
     * Find category by id
     *
     * @param categoryId category id
     * @return category dto
     */
    @GetMapping(path = "categories", params = {"id"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDto findCategoryById(@RequestParam(name = "id") Integer categoryId) {
        return categoryService.findCategoryById(categoryId);
    }

    /**
     * Create categories
     */
    @PostMapping(value = "categories", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDto createCategory(@RequestBody CategoryCreationDto createDto) {
        return categoryService.createCategory(createDto);
    }

    /**
     * Edit Categories
     */
    @PutMapping(value = "categories/{category_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDto editCategory(@PathVariable(name = "category_id") Integer categoryId, @RequestBody CategoryCreationDto createDto) {
        return categoryService.editCategory(categoryId, createDto);
    }

    /**
     * Delete Categories (if they are not referenced in any library item)
     */

    /**
     * Delete a category
     *
     * @param categoryId id of category to delete
     */
    @DeleteMapping(path = "/categories/{category_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteCategoryById(@PathVariable(name = "category_id") Integer categoryId) {
        categoryService.deleteCategoryById(categoryId);
    }

}
