package com.dawn.service.impl;

import com.dawn.dao.UserDao;
import com.dawn.domain.User;
import com.dawn.service.LoginService;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class LoginServiceImpl implements LoginService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(User user) {
        System.out.println("用户名="+user.getUsername());
        //调用dao 查询 用户
        User user1 = userDao.getUser(user.getUsername(), user.getPassword());
        return user1;

    }
}
