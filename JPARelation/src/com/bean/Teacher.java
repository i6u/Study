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

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void removeStudent(Student student) {
        if (this.students.contains(student)) {
            this.students.remove(student);
        }
    }

    @ManyToMany(cascade = CascadeType.REFRESH)//默认就为延迟加载fetch = FetchType.LAZY
    @JoinTable(name = "student_teacher",        //在关系维护端设置中间表信息
            inverseJoinColumns = @JoinColumn(name = "s_id"),//inverseJoinColumns设置关系被维护端在中间表中的信息,其中@joinColumn(name)设置中间表中那个字段与关系被维护端的主键关联
            joinColumns = @JoinColumn(name = "t_id"))//joinColumns设置关系维护端在中间表中的信息,其中@joinColumn(name)设置中间表中那个字段与关系维护端的主键关联
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
