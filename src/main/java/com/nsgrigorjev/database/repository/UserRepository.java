package com.nsgrigorjev.database.repository;

import com.nsgrigorjev.database.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UserRepository implements UserDao<User, Long>{
    @PersistenceContext
    private EntityManager entityManager;
    public User findById(Long id) {
        return entityManager.find(User.class,id);
    }
    public List<User> findAll() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }
    public void deleteById(Long id) {
        entityManager.remove(findById(id));
    }

    public void delete(User entity) {
        entityManager.remove(entity);
    }

    public <S extends User> void persist(S entity) {
        entityManager.persist(entity);
    }

    public <S extends User> void update(S entity) {
        entityManager.merge(entity);
    }


    public void executeNativeQuery(String sql) {
        entityManager.createNativeQuery(sql);
    }
}
