package edu.sliit.service;

import edu.sliit.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void addUser(User user);

    void deleteUserById(Integer id);

    User searchUserById(Integer id);

    void updateUserById(User user);
}
