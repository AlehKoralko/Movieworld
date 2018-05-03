package by.psu.service;

import by.psu.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    User getUserById(int id);

    void updateUser(User user);

    void removeUser(int id);

    List<User> getAllUsers();

    User getByUsername(String username);

}
