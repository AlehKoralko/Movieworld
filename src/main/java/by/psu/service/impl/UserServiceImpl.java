package by.psu.service.impl;

import by.psu.dao.RoleDao;
import by.psu.dao.UserDao;
import by.psu.model.Role;
import by.psu.model.User;
import by.psu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDao.getById(1));
        user.setRoles(roles);
        userDao.add(user);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getById(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.update(user);
    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.remove(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    @Override
    @Transactional
    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }

}
