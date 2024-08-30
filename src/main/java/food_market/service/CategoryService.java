package food_market.service;


import food_market.DTO.CategoryDTO;
import food_market.exceptions.NotFoundException;
import food_market.model.Category;
import food_market.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public String createCategory(CategoryDTO categoryDTO) {

        Category category = new Category();
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return "Successfully created";
    }

    public Category getCategoryById(Integer id) {
        return
                categoryRepository.findById(id).orElseThrow(()-> new NotFoundException("Not fount category"));
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public String updateCategory(CategoryDTO categoryDTO, Integer id) {
        if (!exist(id)) {
            throw new NotFoundException("Not found category by id");
        }
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setId(id);
        categoryRepository.save(category);
        return "successfully updated";
    }

    public String deleteCategory(Integer id) {
        if (!exist(id)) {
            throw new NotFoundException("Not found category by id");
        }
        categoryRepository.deleteById(id);

        return "Successfully deleted";
    }

    private boolean exist(Integer id){
       return categoryRepository.existsById(id);
    }
}
