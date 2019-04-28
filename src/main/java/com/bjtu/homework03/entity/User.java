package com.bjtu.homework03.entity;

import javax.persistence.*;

// 使用jpa註解配置映射關係
@Entity     //告訴jpa這是一個實體類(和數據表映射的類)
@Table(name = "users")   // 指定和哪個數據表對應
public class User {

    @Id //這是一個主鍵
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 主鍵生成策略設爲自增
    private Integer id;

    @Column(name = "uname", length = 50)  // 這是和數據表對應的一個列
    private String uname;
    @Column // 省略默認列名爲屬性
    private String upwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
