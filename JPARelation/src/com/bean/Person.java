package com.bean;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.org.apache.regexp.internal.RE;

import javax.persistence.*;

/**
 * Created by zhouweitao on 16/6/19.
 */
@Entity
public class Person {
    private Integer id;
    private String name;

    private IDCard idCard;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

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

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
