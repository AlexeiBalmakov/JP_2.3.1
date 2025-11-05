package web.dao;

import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager em;


    @Override
    public void addUser(User user) {
        em.persist(user);
    }


    @Override
    public void updateUser(User user) {
        em.merge(user);
    }


    @Override
    public void deleteUser(int id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public List<User> getAllUser() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User find(int id) {
        return em.find(User.class, id);
    }
}
