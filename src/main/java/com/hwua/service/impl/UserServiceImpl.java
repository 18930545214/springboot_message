package com.hwua.service.impl;

import com.hwua.mapper.IUserMapper;
import com.hwua.pojo.User;
import com.hwua.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserMapper userMapper;

    @Override
    public User login(User user) throws Exception {
        return userMapper.queryUserByNameAndPwd(user);
    }

    @Override
    public boolean register(User user) throws Exception {
        return userMapper.saveUser(user)==1?true:false;
    }

    @Override
    public List<User> queryAllUsers() throws Exception {
        return userMapper.queryAllUsers();
    }

    @Override
    public User queryUserById(Long id) throws Exception {
        return userMapper.queryUserById(id);
    }

    @Override
    public boolean queryUserByName(String name) throws Exception {
        return userMapper.queryUserByName(name)==null?true:false;
    }
}
