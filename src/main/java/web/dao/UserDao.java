package web.dao;

import web.Entity.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> getAllUser();

    User find(int id);
}
