package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Article;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Category;

import javax.validation.Valid;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleDao articleDao;
    private final AuthorDao authorDao;
    private final CategoryDao categoryDao;

    public ArticleController(ArticleDao articleDao, AuthorDao authorDao, CategoryDao categoryDao) {
        this.articleDao = articleDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }
    @RequestMapping("/{id}")
    @ResponseBody
    public Article article(@PathVariable Long id){
        return articleDao.findArticleById(id);
    }

/*    @PostMapping("")
    @ResponseBody
    public Article create(@RequestBody Article article){
        articleDao.saveArticle(article);
        return article;
    }*/

    @PutMapping("/{id}")
    @ResponseBody
    public Article update(@PathVariable Long id, @RequestBody Article article){
        Article articleInDb = articleDao.findArticleById(id);
        articleInDb.setTitle(article.getTitle());
        articleInDb.setAuthor(article.getAuthor());
        articleInDb.setCategories(article.getCategories());
        articleInDb.setContent(article.getContent());
        articleInDb.setUpdated(article.getUpdated());
        articleInDb.setCreated(article.getCreated());
        articleDao.updateArticle(articleInDb);
        return  articleInDb;
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id){
        articleDao.deleteArticle(article(id));
    }

    @RequestMapping("/populate")
    @ResponseBody
    public void populateWithArticles(){
        String content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam id nisl sapien. Nulla dignissim non dui eu efficitur. Aenean non lectus dictum, gravida lorem et, imperdiet sapien. Nullam ac eros enim. Aliquam lobortis feugiat est, ac sollicitudin magna venenatis at. Nullam quis placerat eros. Nunc congue, nunc vitae efficitur tempor, velit libero convallis metus, eu finibus purus orci sed erat.\n" +
                "\n" +
                "Phasellus imperdiet, lacus commodo lacinia ultricies, nibh nunc gravida enim, ut finibus massa leo nec ipsum. Sed sit amet nibh vitae risus ullamcorper pharetra. Aenean a diam id turpis gravida viverra.";
        for (int i = 1; i < 6; i++) {
            Article article = new Article();
            article.setTitle("title"+i);
            article.setCreated(LocalTime.now());
            article.setContent(content+i);
            article.setAuthor(authorDao.findAuthorById(1L));
            article.setCategories(Arrays.asList(categoryDao.findCategoryById(1L),categoryDao.findCategoryById(2L)));article.setUpdated(null);
            articleDao.saveArticle(article);
        }
    }
    //Form controllers
    //Wyświetlanie wszystkich artykułów
    @GetMapping("/all")
    public String getAllArticles(Model model){
        List<Article> articles = articleDao.findAllArticles();
        model.addAttribute("articles", articles);
        return "articles";
    }
    //  Dodawanie nowego artykułu po odpowiedniej walidacji
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getArticleForm(Model model) {
        model.addAttribute("article", new Article());
        return "articleForm";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String create(@Valid Article article, BindingResult result) {
        if (result.hasErrors()){
            return "articleForm";
        }
        article.setCreated(LocalTime.now());
        articleDao.saveArticle(article);
        return ("redirect:/articles/all");
    }
    // Edytowanie artykułu z odpowiednią walidacją
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String getEditForm(Model model, @PathVariable long id) {
        Article article = articleDao.findArticleById(id);
        model.addAttribute("article", article);
        return "editArticleForm";
    }
    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST)
    public String update(@Valid Article article, BindingResult result) {
        if (result.hasErrors()){
            return "editArticleForm";
        }
        article.setCreated(articleDao.findArticleById(article.getId()).getCreated());
        article.setUpdated(LocalTime.now());
        articleDao.updateArticle(article);
        return "redirect:/articles/all";
    }
    // Usuwanie kategorii
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute Article article){
        articleDao.deleteArticle(article);
        return "redirect:/articles/all";
    }
    @ModelAttribute("categories")
    public List<Category> categoryList(){
        return categoryDao.findAllCategories();
    }

    @ModelAttribute("authors")
    public List<Author> authorList(){
        return authorDao.findAllAuthors();
    }
}
