package com.hwua.service;


import com.hwua.pojo.User;

import java.util.List;

public interface IUserService {
    public User login(User user)throws Exception;//登录
    public boolean register(User user)throws Exception;//注册
    public List<User> queryAllUsers() throws Exception; //查询所有的用户
    public User queryUserById(Long id)throws Exception; //查询发送者用户信息
    public boolean queryUserByName(String name)throws Exception;//判断用户名是否已经注册
}
