package web.dao;

import web.entity.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    List<User> getAllUsers();

    void updateUser(User editedUser, int id);

    User getUserById(int id);

    void removeUser(int id);

}
