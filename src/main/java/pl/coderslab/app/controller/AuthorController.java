package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorDao authorDao;

    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public Author author(@PathVariable Long id){
        return authorDao.findAuthorById(id);
    }

/*    @PostMapping("")
    @ResponseBody
    public Author create(@RequestBody Author author){
        authorDao.saveAuthor(author);
        return author;
    }*/

    @PutMapping("/{id}")
    @ResponseBody
    public Author update(@PathVariable Long id, @RequestBody Author author){
        Author authorInDb = authorDao.findAuthorById(id);
        authorInDb.setFirstName(author.getFirstName());
        authorInDb.setLastName(author.getLastName());
        authorDao.updateAuthor(authorInDb);
        return authorInDb;
    }
    /*@DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        authorDao.deleteAuthor();
    }
*/
    @RequestMapping("/populate")
    @ResponseBody
    public void populateWithAuthors(){
        for (int i = 1; i < 6; i++) {
            Author author = new Author();
            author.setFirstName("firstName"+i);
            author.setLastName("lastName"+i);
            authorDao.saveAuthor(author);
        }
    }
    //Form controllers
    //Wyświetlanie wszystkich kategorii
    @GetMapping("/all")
    public String getAllAuthors(Model model){
        List<Author> authors = authorDao.findAllAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }
    //  Dodawanie nowej kategorii po odpowiedniej walidacji
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@Valid Author author, BindingResult result) {
        if (result.hasErrors()){
            return "authorForm";
        }
        authorDao.saveAuthor(author);
        return ("redirect:/categories/all");
    }
    // Edytowanie kategorii z odpowiednią walidacją
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String getEditForm(Model model, @PathVariable long id) {
        Author author = authorDao.findAuthorById(id);
        model.addAttribute("author", author);
        return "editAuthorForm";
    }
    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String update(@Valid Author author,BindingResult result) {
        if (result.hasErrors()){
            return "editAuthorForm";
        }
        authorDao.updateAuthor(author);
        return "redirect:/authors/all";
    }
    // Usuwanie kategorii
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute Author author){
        authorDao.deleteAuthor(author);
        return "redirect:/categories/all";
    }
}
