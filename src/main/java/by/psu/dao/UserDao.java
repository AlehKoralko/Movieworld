package by.psu.dao;

import by.psu.model.User;

import java.util.List;

public interface UserDao extends CrudDao<User> {

    List<User> getAllUsers();

    User getByUsername(String username);

}
