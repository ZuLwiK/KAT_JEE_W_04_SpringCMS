package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.entity.Article;

import java.util.List;

@Controller
public class HomePageController {
    private final ArticleDao articleDao;

    public HomePageController(ArticleDao articleDao) {
        this.articleDao = articleDao;

    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String lastFiveArticles(Model model) {
        List<Article> articles = articleDao.findLastFiveArticles();
        model.addAttribute("articles",articles);
        return "home";
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
