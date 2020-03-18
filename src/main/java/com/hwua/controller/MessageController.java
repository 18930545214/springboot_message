package com.hwua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.pojo.Message;
import com.hwua.pojo.User;
import com.hwua.service.IMessageService;
import com.hwua.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private IMessageService msgService;

    @GetMapping("/queryAllMessage/{pageNo}/{pageSize}")
    @ResponseBody
    public PageInfo<Message> queryAllMessage(@PathVariable("pageNo") Integer pageNo, @PathVariable("pageSize") Integer pageSize, HttpSession session) throws Exception {
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(pageNo, pageSize);
        List<Message> list = msgService.queryMessageByLoginUser(user.getId());
        System.out.println(list);
        PageInfo<Message> pageInfo = new PageInfo<>(list);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @GetMapping("/queryMessageById/{id}")
    public ModelAndView queryMsgById(@PathVariable("id") Long id) throws Exception {
        ModelAndView mv = new ModelAndView();
        Message msg = msgService.queryMessageById(id);
        System.out.println(msg);
        mv.addObject("msg", msg);
        mv.setViewName("readMsg");
        return mv;
    }

    @DeleteMapping("/deleteMessageById/{id}")
    @ResponseBody
    public String delMsg(@PathVariable("id") Long id) throws Exception {
        int res = msgService.deleteMessageById(id);
        if (res > 0) {
            return "success";
        }
        return "";
    }

    @PostMapping("/sendMessage")
    @ResponseBody
    public String sendMessage(String title, String content,Long toUser, HttpSession session) throws Exception {
        Long sendId = ((User) session.getAttribute("user")).getId();
        title = StringUtil.replaceStr(title);
        content = StringUtil.replaceStr(content);
        String msg_create_date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        int state = 1;
        Message msg = new Message(null,sendId, title, content, state, toUser, msg_create_date,null);
        int res = msgService.sendMessage(msg);
        String str = res > 0 ? "success" : "failure";
        return str;
    }
}
