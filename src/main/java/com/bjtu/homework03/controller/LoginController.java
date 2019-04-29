package com.bjtu.homework03.controller;

import com.bjtu.homework03.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping({"/", "/login", "login.html"})
    public String login() {
        return "login";
    }

    @RequestMapping({"/main", "main.html"})
    public String main() {
        return "main";
    }

    @Autowired
    LoginService loginService;

    @PostMapping
    @RequestMapping("user/loginPost")
    public String loginPost(@RequestParam("uname") String uname,
                            @RequestParam("upwd") String upwd,
                            Map<String, Object> map,
                            HttpSession session) {
        if (loginService.Login(uname, upwd)) {
            //登陆成功
            logger.info("login ok");
            session.setAttribute("loginUser", uname);
            return "redirect:/main";//重定向到页面，而不是使用/user/loginPost链接
        } else {
            //登录失败
            logger.info("login not ok");
            map.put("msg", "用户名密码错误");
            //返回的页面  login.html
            return "redirect:/";
        }
    }
}
