package com.hwua.mapper;

import com.hwua.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IUserMapper {
    public int saveUser(User user) throws Exception;//增加
    public List<User> queryAllUsers() throws Exception;//查询全部
    public User queryUserByNameAndPwd(User user) throws Exception;//按用户名密码查询
    public User queryUserById(Long id) throws Exception;//按ID查询
    public User queryUserByName(String name) throws Exception;//按姓名查询

}
