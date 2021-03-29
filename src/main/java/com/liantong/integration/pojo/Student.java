package com.liantong.integration.pojo;


import indi.mybatis.flying.annotations.FieldMapperAnnotation;
import org.apache.ibatis.type.JdbcType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "STUDENT")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "_ID")
    private String id;

    /**
     * 姓名
     *
     */
    @Column(name = "NAME")
    private String name;

    /**
     * 关联角色
     *
     */
    @FieldMapperAnnotation(dbFieldName = "CLASSES_ID", jdbcType = JdbcType.VARCHAR, dbAssociationUniqueKey = "ID")
    private Classes classes;

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

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes newClasses) {
        if (this.classes == null || !this.classes.equals(newClasses)) {
            if (this.classes != null) {
                Classes oldClasses = this.classes;
                this.classes = null;
                oldClasses.removeStudent(this);
            }
            if (newClasses != null) {
                this.classes = newClasses;
                this.classes.addStudent(this);
            }
        }
    }

}