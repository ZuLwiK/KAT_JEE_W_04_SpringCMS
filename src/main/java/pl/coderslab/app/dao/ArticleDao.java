package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article article) {
        article.setCreated(LocalDateTime.now());
        entityManager.persist(article);
    }

    public void deleteArticle(Long id) {
        entityManager.remove(findArticleById(id));
    }

    public Article findArticleById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void updateArticle(Article article) {
        article.setUpdated(LocalDateTime.now());
        entityManager.merge(article);
    }
    public List<Article> findLastFiveArticles(){
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC");
        query.setMaxResults(5);
        List<Article> articles = query.getResultList();
        return articles;
    }
    public List<Article> findAllArticles(){
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC");
        List<Article> articles = query.getResultList();
        return articles;
    }
}
