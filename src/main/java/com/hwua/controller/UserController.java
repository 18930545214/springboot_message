package com.hwua.controller;

import com.hwua.pojo.User;
import com.hwua.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/Code")
    @ResponseBody
    public Map<String, Object> Code(String code, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Object validateCode = session.getAttribute("validateCode");//随机验证码
        if (code.equals(validateCode)) {
            map.put("info", "success");
        } else {
            map.put("info", "failure");
        }
        return map;
    }

    @GetMapping("/queryUserByName")
    @ResponseBody
    public Map<String, Object> queryUserByName(String name) throws Exception {
        Map<String, Object> map = new HashMap<>();
        boolean flag = userService.queryUserByName(name);
        map.put("info", flag);
        return map;
    }
    @ResponseBody
    @GetMapping("/login")
    public Map<String, Object> login(User user, HttpSession session) throws Exception {
        Map<String, Object> map = new HashMap<>();
        user = userService.login(user);
        //登录成功
        if (user != null) {
            session.removeAttribute("validateCode");
            session.setAttribute("user", user);
            //调用Servlet,获取当前登录用户所收到的所有短消息
            map.put("info", "success");
        } else {
            map.put("info", "");
            map.put("error", "failure");
        }
        return map;
    }
    @ResponseBody
    @PostMapping("/register")
    public Map<String, Object> register(User user) throws Exception {
        Map<String, Object> map = new HashMap<>();
        boolean flag = userService.register(user);//调用业务方法
        if (flag) {
            map.put("info", "success");
        } else {
            map.put("info", "failure");
        }
        return map;
    }
    @GetMapping("/queryAllUser/{id}")
    public ModelAndView queryAllUser(@PathVariable Long id)throws Exception{
        List<User> uList = userService.queryAllUsers();
        System.out.println(uList);
        ModelAndView mv = new ModelAndView();
        mv.addObject("sendId",id);
        mv.addObject("uList",uList);
        mv.setViewName("newMsg");
        return mv;
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) throws Exception{
        if(session!=null){
            session.invalidate();
        }
        return "redirect:/index.jsp";
    }
}
