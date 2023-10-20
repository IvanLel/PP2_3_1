package web.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.entity.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;


    @Override
    public void add(User user) {
        em.persist(user);
    }

    @Override
    public void removeUser(int id) {
        em.remove(em.find(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = em.createQuery("from User", User.class).getResultList();

        return userList == null ? new ArrayList<>() : userList;
    }

    @Override
    public void updateUser(User editedUser, int id) {
        User persistedUser = em.find(User.class, id);
        persistedUser.setName(editedUser.getName());
        persistedUser.setSurname(editedUser.getSurname());
        persistedUser.setDepartment(editedUser.getDepartment());
        persistedUser.setSalary(editedUser.getSalary());

    }

    @Override
    public User getUserById(int id) {
        return em.find(User.class, id);
    }
}
