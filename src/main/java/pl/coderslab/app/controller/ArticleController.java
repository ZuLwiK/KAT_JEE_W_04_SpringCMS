package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.dao.AuthorDao;
import pl.coderslab.app.dao.CategoryDao;
import pl.coderslab.app.entity.Article;

import java.time.LocalDateTime;
import java.util.Arrays;

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

    @PostMapping("")
    @ResponseBody
    public Article create(@RequestBody Article article){
        articleDao.saveArticle(article);
        return article;
    }

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
        articleDao.deleteArticle(id);
    }

    @RequestMapping("/populate")
    @ResponseBody
    public void populateWithArticles(){
        for (int i = 1; i < 6; i++) {
            Article article = new Article();
            article.setTitle("title"+i);
            article.setCreated(LocalDateTime.now());
            article.setContent("content"+i);
            article.setAuthor(authorDao.findAuthorById(1L));
            article.setCategories(Arrays.asList(categoryDao.findCategoryById(1L),categoryDao.findCategoryById(2L)));article.setUpdated(null);
            articleDao.saveArticle(article);
        }
    }
}
