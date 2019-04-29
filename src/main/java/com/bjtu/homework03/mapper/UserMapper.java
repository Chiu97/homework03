package com.bjtu.homework03.mapper;

import com.bjtu.homework03.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from users where uname=#{uname} and upwd=#{upwd}")
    public User getUser(@Param("uname") String uname, @Param("upwd") String upwd);

}
