package com.hwua.mapper;

import com.hwua.pojo.Message;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface IMessageMapper {
    public int saveMessage(Message message) throws Exception;//增加
    public int deleteMessageById(Long id) throws Exception;//删除
    public List<Message> queryMessageByLoginUser(Long loginId) throws Exception;//按receiveId查询
    public Message queryMessageById(Long id) throws Exception;//按ID查询
    public int updateMessage(Message message)throws Exception;//更改状态
}
