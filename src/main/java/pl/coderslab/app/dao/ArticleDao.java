package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void saveArticle(Article article) {
        article.setCreated(LocalTime.now());
        entityManager.persist(article);
    }

    public void deleteArticle(Article article) {
        entityManager.remove(entityManager.contains(article) ? article : entityManager.merge(article));
    }

    public Article findArticleById(Long id) {
        return entityManager.find(Article.class, id);
    }

    public void updateArticle(Article article) {
//        article.setCreated(article.getCreated());
//        article.setUpdated(LocalTime.now());
        entityManager.merge(article);
    }

    public List<Article> findLastFiveArticles() {
        Query query = entityManager.createQuery("SELECT a FROM Article a ORDER BY a.created DESC");
        query.setMaxResults(5);
        List<Article> articles = query.getResultList();
        return articles;
    }

    public List<Article> findAllArticles() {
//        Query query = entityManager.createQuery("SELECT article FROM Article article LEFT JOIN FETCH article.categories category ORDER BY article.created DESC ");
        Query query = entityManager.createQuery("SELECT article FROM Article article ORDER BY article.created DESC ");
        List<Article> articles = query.getResultList();
        return articles;
    }
}
