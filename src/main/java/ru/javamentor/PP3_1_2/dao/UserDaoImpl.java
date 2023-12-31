package ru.javamentor.PP3_1_2.dao;

import org.springframework.stereotype.Repository;
import ru.javamentor.PP3_1_2.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeById(Long id) {
        entityManager.createQuery("DELETE FROM User user WHERE user.id = :id").setParameter("id", id).executeUpdate();
    }

    @Override
    public User getById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(User user, Long id) {
        user.setId(id);
        entityManager.merge(user);
    }

}
