package com.bean;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by zhouweitao on 16/6/20.
 */
@Entity
@Table(name = "t_AirLine")
public class AirLine {
    private AirLinePK id;
    private String name;

    public AirLine() {
    }

    public AirLine(AirLinePK id) {
        this.id = id;
    }

    public AirLine(AirLinePK id, String name) {
        this.id = id;
        this.name = name;
    }

    public AirLine(String startCity, String endCity, String name) {
        this.id = new AirLinePK(startCity, endCity);
        this.name = name;

    }


    @EmbeddedId//声明此字段是嵌入的一个类作为了这个实体的主键
    public AirLinePK getId() {
        return id;
    }

    public void setId(AirLinePK id) {
        this.id = id;
    }

    @Column(length = 20,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
