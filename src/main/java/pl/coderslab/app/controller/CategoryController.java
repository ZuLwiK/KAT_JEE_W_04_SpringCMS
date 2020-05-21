package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Category;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryDao categoryDao;

    public CategoryController(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }


    @RequestMapping("/{id}")
    @ResponseBody
    public Category category(@PathVariable Long id){
        return categoryDao.findCategoryById(id);
    }

    @PostMapping("")
    @ResponseBody
    public Category create(@RequestBody Category category){
        categoryDao.saveCategory(category);
        return category;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Category update(@PathVariable Long id, @RequestBody Category category){
        Category categoryinDb = categoryDao.findCategoryById(id);
        categoryinDb.setName(category.getName());
        categoryinDb.setDescription(category.getDescription());
        categoryDao.updateCategory(categoryinDb);
        return categoryinDb;
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        categoryDao.deleteCategory(id);
    }

    @RequestMapping("/populate")
    @ResponseBody
    public void populateWithCategories(){
        for (int i = 1; i < 6; i++) {
            Category category = new Category();
            category.setName("name"+i);
            category.setDescription("description"+i);
            categoryDao.saveCategory(category);
        }
    }

}
