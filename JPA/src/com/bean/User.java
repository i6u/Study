package com.bean;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhouweitao on 16/6/16.
 */
@Entity //声明一个实体
@Table(name = "t_user") //设置表命为t_user
public class User implements Serializable {
    private Integer id;
    private String name;
    private Date birthday;
    private Gender gender;


    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Column(length = 10)
    @Enumerated(EnumType.STRING) //声明枚举类型，String保存字符串，Ordinal保存索引(索引从0开始)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column(name = "uNanme", length = 20, nullable = false, unique = true) //设置字段名，长度，不允许空，唯一
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id //设置主键
    @GeneratedValue(strategy = GenerationType.AUTO)//设置主键增长 AUTO为默认可以不写
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    @Temporal(TemporalType.TIME) //定义日期格式temporalType的值可根据实际需求选择
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                '}';
    }
}
