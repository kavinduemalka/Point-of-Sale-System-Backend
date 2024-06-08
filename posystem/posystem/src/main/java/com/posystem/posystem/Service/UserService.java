package com.posystem.posystem.Service;

import com.posystem.posystem.entity.Items;
import com.posystem.posystem.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAllUsers();

    User createUser(User user);
}
