package pl.coderslab.app.converter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.app.dao.ArticleDao;
import pl.coderslab.app.entity.Article;

public class ArticleConverter implements Converter<String, Article> {
    @Autowired
    ArticleDao articleDao;

    @Override
    public Article convert(String sourceId) {
        return articleDao.findArticleById(Long.parseLong(sourceId));
    }
}
