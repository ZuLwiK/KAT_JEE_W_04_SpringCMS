package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.app.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional
public class AuthorDao {
    @PersistenceContext
    EntityManager entityManager;

    public void save(Author author) {
        entityManager.persist(author);
    }

    public void delete(Author author) {
        entityManager.remove(author);
    }

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }
}
