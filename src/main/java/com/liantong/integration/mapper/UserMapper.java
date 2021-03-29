package com.liantong.integration.mapper;

import com.liantong.integration.pojo.User;

public interface  UserMapper {

    public void insert(User user);
    public User select(Object id);

}
