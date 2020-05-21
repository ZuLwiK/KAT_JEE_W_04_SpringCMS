package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.entity.Author;

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

    @PostMapping("")
    @ResponseBody
    public Author create(@RequestBody Author author){
        authorDao.saveAuthor(author);
        return author;
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Author update(@PathVariable Long id, @RequestBody Author author){
        Author authorInDb = authorDao.findAuthorById(id);
        authorInDb.setFirstName(author.getFirstName());
        authorInDb.setLastName(author.getLastName());
        authorDao.updateAuthor(authorInDb);
        return authorInDb;
    }
    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        authorDao.deleteAuthor(id);
    }

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
}
