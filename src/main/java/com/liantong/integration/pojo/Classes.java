package com.liantong.integration.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


import com.alibaba.fastjson.annotation.JSONField;


@Table(name = "CLASSES")
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String name;


    private java.util.Collection<Student> students;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public java.util.Collection<Student> getStudents() {
        if (students == null) {
            students = new java.util.LinkedHashSet<Student>();
        }
        return students;
    }

    @JSONField(serialize = false)
    public java.util.Iterator<Student> getIteratorStudent() {
        if (students == null) {
            students = new java.util.LinkedHashSet<Student>();
        }
        return students.iterator();
    }

    public void setStudents(java.util.Collection<Student> newPerson) {
        removeAllStudent();
        for (java.util.Iterator<Student> iter = newPerson.iterator(); iter.hasNext();) {
            addStudent((Student) iter.next());
        }
    }

    public void addStudent(Student newPerson) {
        if (newPerson == null) {
            return;
        }
        if (this.students == null) {
            this.students = new java.util.LinkedHashSet<Student>();
        }
        if (!this.students.contains(newPerson)) {
            this.students.add(newPerson);
            newPerson.setClasses(this);
        } else {
            for (Student temp : this.students) {
                if (newPerson.equals(temp)) {
                    if (temp != newPerson) {
                        removeStudent(temp);
                        this.students.add(newPerson);
                        newPerson.setClasses(this);
                    }
                    break;
                }
            }
        }
    }

    public void removeStudent(Student oldStudent) {
        if (oldStudent == null) {
            return;
        }
        if (this.students != null) {
            if (this.students.contains(oldStudent)) {
                for (Student temp : this.students) {
                    if (oldStudent.equals(temp)) {
                        if (temp != oldStudent) {
                            temp.setClasses(null);
                        }
                        break;
                    }
                }
                this.students.remove(oldStudent);
                oldStudent.setClasses(null);
            }
        }
    }

    public void removeAllStudent() {
        if (students != null) {
            Student oldStudent;
            for (java.util.Iterator<Student> iter = getIteratorStudent(); iter.hasNext();) {
                oldStudent = (Student) iter.next();
                iter.remove();
                oldStudent.setClasses(null);
            }
            students.clear();
        }
    }
}
