package com.liantong.integration.service;

import com.liantong.integration.mapper.UserMapper;
import com.liantong.integration.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public User select(Object id) {
        return userMapper.select(id);
    }
}
