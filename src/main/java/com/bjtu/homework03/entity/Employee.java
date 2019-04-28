package com.bjtu.homework03.entity;

import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Date;

//使用JPA注解配置映射关系
@Entity //告诉jpa这是一个实体类
@Table(name = "employees") //指定和哪个数据表对应；如果省略，默认表名字是类名小写
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer age;
    @Column
    private Integer sex;
    @Column
    private Date birth;
    @Column
    private Integer phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
