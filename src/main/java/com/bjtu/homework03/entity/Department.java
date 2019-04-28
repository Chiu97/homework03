package com.bjtu.homework03.entity;

import javax.persistence.*;

//使用JPA注解配置映射关系
@Entity //告诉jpa这是一个实体类
@Table(name = "departments") //指定和哪个数据表对应；如果省略，默认表名字是类名小写
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //自增主键
    private Integer id;
    @Column  //如果省略，默认表名字是属性名小写
    private String name;
    @Column  //如果省略，默认表名字是属性名小写
    private String address;
    @Column  //如果省略，默认表名字是属性名小写
    private Integer area;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}
