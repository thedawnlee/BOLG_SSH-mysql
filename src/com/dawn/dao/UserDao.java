package com.dawn.dao;

import com.dawn.domain.User;

public interface UserDao {
    public User getUser(String username, String password);
}
