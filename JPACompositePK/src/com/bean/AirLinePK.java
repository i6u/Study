package com.bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by zhouweitao on 16/6/20.
 * jpa联合主键
 *
 * 需要注意的地方:
 * 1.必须提供一个public的无参数构造方法
 * 2.必须实现序列化接口
 * 3.必须重写equals和hashCode方法
 */
@Embeddable//声明此类只是作为其他类的一个持久化字段
public class AirLinePK implements Serializable{
    private String startCity;
    private String endCity;

    public AirLinePK() {
    }

    public AirLinePK(String startCity, String endCity) {
        this.startCity = startCity;
        this.endCity = endCity;
    }

    @Column(length = 3)
    public String getStartCity() {
        return startCity;
    }

    public void setStartCity(String startCity) {
        this.startCity = startCity;
    }

    @Column(length = 3)
    public String getEndCity() {
        return endCity;
    }

    public void setEndCity(String endCity) {
        this.endCity = endCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AirLinePK airLinePK = (AirLinePK) o;

        if (startCity != null ? !startCity.equals(airLinePK.startCity) : airLinePK.startCity != null) return false;
        return endCity != null ? endCity.equals(airLinePK.endCity) : airLinePK.endCity == null;

    }

    @Override
    public int hashCode() {
        int result = startCity != null ? startCity.hashCode() : 0;
        result = 31 * result + (endCity != null ? endCity.hashCode() : 0);
        return result;
    }
}
