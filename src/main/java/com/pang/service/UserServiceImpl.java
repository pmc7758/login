package com.pang.service;


import com.pang.entity.User;
import com.pang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User login(User user) {
        //根据账号密码查询
        User userDB = userMapper.login(user);
        if (userDB != null) {
            return userDB;
        }
        throw new RuntimeException("登录失败");
    }

}
