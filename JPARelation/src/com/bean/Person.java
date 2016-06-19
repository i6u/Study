package com.bean;

import com.sun.istack.internal.Nullable;

import javax.persistence.*;

/**
 * Created by zhouweitao on 16/6/19.
 */
public class Person {
    private Integer id;
    private String name;

    private IDCard idCard;

    @OneToOne(optional = false,cascade = {CascadeType.ALL})
    @JoinColumn(name = "idCard_Id")//外键信息一般设置在关系维护端
    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
