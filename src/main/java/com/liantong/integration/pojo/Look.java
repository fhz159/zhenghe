package com.liantong.integration.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
@Table(name = "LOOK")
public class Look implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SV")
    private Integer sv;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSv() {
        return sv;
    }

    public void setSv(Integer sv) {
        this.sv = sv;
    }
}
