package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

    List<User> getAllUser();

    User find(int id);
}
