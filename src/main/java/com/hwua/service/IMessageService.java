package com.hwua.service;

import com.hwua.pojo.Message;

import java.util.List;

public interface IMessageService {

    public List<Message> queryMessageByLoginUser(Long loginId)throws Exception;// 查询登录用户收到的所有短消息

    public Message queryMessageById(Long id)throws Exception; //根据id来查询一条短消息

    public int sendMessage(Message msg)throws Exception;//发送短消息

    public int deleteMessageById(Long id)throws Exception;// 删除一条短消息


}
