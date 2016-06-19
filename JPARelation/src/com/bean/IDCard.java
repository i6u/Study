package com.bean;

import javax.persistence.*;

/**
 * Created by zhouweitao on 16/6/19.
 */

@Entity
public class IDCard {
    private Integer id;
    private String cardNo;

    private Person person;

    public IDCard() {
    }

    public IDCard(String cardNo) {
        this.cardNo = cardNo;
    }

    @OneToOne(mappedBy = "idCard",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH})//关系被维护端没有权利更新主外键关系,optional设置是否可以为空
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 18,nullable = false)
    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}
