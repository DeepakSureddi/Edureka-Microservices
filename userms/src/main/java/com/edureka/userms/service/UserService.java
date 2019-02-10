package com.edureka.userms.service;

import com.edureka.userms.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getSingleUser(Long userId);
    void createUser(User user);
    void deleteUser(Long userId);
    void updateUser(User user);
}
