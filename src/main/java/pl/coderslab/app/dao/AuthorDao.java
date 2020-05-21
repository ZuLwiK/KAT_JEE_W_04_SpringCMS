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

    public void saveAuthor(Author author) {
        entityManager.persist(author);
    }

    public void deleteAuthor(Long id) {
        entityManager.remove(findAuthorById(id));
    }

    public Author findAuthorById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void updateAuthor(Author author) {
        entityManager.merge(author);
    }
}
