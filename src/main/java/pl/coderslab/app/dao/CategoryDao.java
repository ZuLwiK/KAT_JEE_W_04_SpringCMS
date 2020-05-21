package pl.coderslab.app.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.entity.Category;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CategoryDao {


    @PersistenceContext
    EntityManager entityManager;
    public void saveCategory (Category category) {
        entityManager.persist(category);
    }
    public void deleteCategory (Long id) {
        entityManager.remove(findCategoryById(id));
    }
    public Category findCategoryById (Long id) {
        return entityManager.find(Category.class, id);
    }
    public void updateCategory(Category category) {
        entityManager.merge(category);
    }

}
