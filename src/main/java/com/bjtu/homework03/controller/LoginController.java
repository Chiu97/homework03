package com.bjtu.homework03.controller;

import com.bjtu.homework03.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

//description已经被弃用了,所以就用tags来代替
@Api(value = "用户登录", tags = {"loginTag"})
@Controller
public class LoginController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "用户登录" , notes = "进入了用户登录界面")
    @RequestMapping({"/", "/login", "login.html"})
    public String login() {
        return "login";
    }

    @ApiOperation(value = "主界面", notes = "进入页面的主界面")
    @RequestMapping({"/main", "main.html"})
    public String main() {
        return "main";
    }

    @Autowired
    LoginService loginService;

    @ApiOperation(value = "提交登录", notes = "以Post来提交登录请求")
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
