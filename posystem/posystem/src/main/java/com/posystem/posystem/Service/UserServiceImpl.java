package com.posystem.posystem.Service;

import com.posystem.posystem.entity.User;
import com.posystem.posystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
