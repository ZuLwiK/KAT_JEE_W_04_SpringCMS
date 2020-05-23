package pl.coderslab.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Category;

import javax.validation.Valid;
import java.util.List;

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

//    @PostMapping("")
//    @ResponseBody
//    public Category create(@RequestBody Category category){
//        categoryDao.saveCategory(category);
//        return category;
//    }

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
        categoryDao.deleteCategory(categoryDao.findCategoryById(id));
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
    //Form controllers
    //Wyświetlanie wszystkich kategorii
    @GetMapping("/all")
    public String getAllCategories(Model model){
        List<Category> categories = categoryDao.findAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    //  Dodawanie nowej kategorii po odpowiedniej walidacji
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getCategoryForm(Model model) {
        model.addAttribute("category", new Category());
        return "categoryForm";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@Valid Category category, BindingResult result) {
        if (result.hasErrors()){
            return "categoryForm";
        }
        categoryDao.saveCategory(category);
        return ("redirect:/categories/all");
    }
    // Edytowanie kategorii z odpowiednią walidacją
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String getEditForm(Model model, @PathVariable long id) {
        Category category = categoryDao.findCategoryById(id);
        model.addAttribute("category", category);
        return "editCategoryForm";
    }
    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String update(@Valid Category category,BindingResult result) {
        if(result.hasErrors()){
            return "editCategoryForm";
        }
        categoryDao.updateCategory(category);
        return "redirect:/categories/all";
    }
    // Usuwanie kategorii
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute Category category){
        categoryDao.deleteCategory(category);
        return "redirect:/categories/all";
    }
}
