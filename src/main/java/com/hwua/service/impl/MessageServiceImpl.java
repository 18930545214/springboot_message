package com.hwua.service.impl;

import com.hwua.mapper.IMessageMapper;
import com.hwua.pojo.Message;
import com.hwua.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private IMessageMapper messageMapper;


    @Override
    public List<Message> queryMessageByLoginUser(Long loginId) throws Exception {
        return messageMapper.queryMessageByLoginUser(loginId);
    }

    @Override
    public Message queryMessageById(Long id) throws Exception {
        Message msg = messageMapper.queryMessageById(id);
        msg.setState(0);
        messageMapper.updateMessage(msg);
        return msg;
    }

    @Override
    public int sendMessage(Message msg) throws Exception {
        return messageMapper.saveMessage(msg);
    }

    @Override
    public int deleteMessageById(Long id) throws Exception {
        return messageMapper.deleteMessageById(id);
    }
}
