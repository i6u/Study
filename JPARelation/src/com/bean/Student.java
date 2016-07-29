package com.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhouweitao on 16/6/20.
 */
@Entity
public class Student {
    private Integer id;
    private String name;
    private Set<Teacher> teachers = new HashSet<Teacher>();

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void addTeacher(Teacher teacher) {
        this.teachers.add(teacher);
    }

    public void reomveTeacher(Teacher teacher) {//此方法首先得判断teacher是否存在于teachers的set集合中,所以得重写(teacher实体的)equals和hashCode方法
        if (this.teachers.contains(teacher)) this.teachers.remove(teacher);
    }

    @ManyToMany(cascade = CascadeType.REFRESH)//多对对关联关系
    @JoinTable(name = "student_teacher",        //在关系维护端设置中间表信息
            inverseJoinColumns = @JoinColumn(name = "t_id"),//inverseJoinColumns设置关系被维护端在中间表中的信息,其中@joinColumn(name)设置中间表中那个字段与关系被维护端的主键关联
            joinColumns = @JoinColumn(name = "s_id"))//joinColumns设置关系维护端在中间表中的信息,其中@joinColumn(name)设置中间表中那个字段与关系维护端的主键关联
    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return id != null ? id.equals(student.id) : student.id == null;

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
