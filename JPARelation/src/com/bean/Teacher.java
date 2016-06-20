package com.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouweitao on 16/6/20.
 */

@Entity
public class Teacher {
    private Integer id;
    private String name;
    private Set<Student> students = new HashSet<Student>();

    public Teacher() {
    }

    public Teacher(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.REFRESH,mappedBy = "teachers",fetch = FetchType.LAZY)//默认就为延迟加载
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 10,nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
