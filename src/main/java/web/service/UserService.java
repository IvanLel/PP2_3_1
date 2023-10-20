package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {

    void add(User user);

    void removeUser(int id);

    List<User> getAllUsers();

    void updateUser(User editedUser, int id);

    User getUserById(int id);



}
