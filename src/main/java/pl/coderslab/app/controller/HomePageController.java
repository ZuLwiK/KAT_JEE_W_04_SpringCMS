package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.entity.Article;
import pl.coderslab.app.entity.Author;
import pl.coderslab.app.entity.Category;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomePageController {
    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;

    }

    @RequestMapping("/")
    @ResponseBody
    public List<Article> lastFiveArticles() {
        List<Article> articles = articleDao.findLastFiveArticles();
        return articles;
    }
//    @RequestMapping("/populate")
//    @ResponseBody
//    public void populateWithExampleArticles(){
//        Category category = new Category("example category","example description");
//        Author author = new Author();
//        for (int i = 0; i < 10; i++) {
//            Article article = new Article(();
//            articleDao.saveArticle(article);
//        }
//    }
}
