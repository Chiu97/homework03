package com.bjtu.homework03.service;

import com.bjtu.homework03.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    UserMapper userMapper;

    @Cacheable(cacheNames = {"login"})
    public boolean Login(String uname,String upwd){
        logger.info("\n登录信息：\n账号："+uname+"\n密码："+upwd);
        if (userMapper.getUser(uname,upwd) != null){
            return true;
        }else {
            return false;
        }
    }
}
