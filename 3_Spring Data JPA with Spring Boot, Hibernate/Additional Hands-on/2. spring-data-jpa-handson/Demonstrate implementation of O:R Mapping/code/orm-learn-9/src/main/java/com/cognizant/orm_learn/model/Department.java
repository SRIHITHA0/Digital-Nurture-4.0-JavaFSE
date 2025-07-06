package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Student> students;

    // ✅ Add getter and setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ✅ Add getter and setter for 'students' if needed
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    // ✅ Optional: toString
    @Override
    public String toString() {
        return "Department{id=" + id + ", name='" + name + "'}";
    }
}
