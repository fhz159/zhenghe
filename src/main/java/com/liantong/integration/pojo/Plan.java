package com.liantong.integration.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import indi.mybatis.flying.annotations.FieldMapperAnnotation;

@Table(name = "PLAN")
public class Plan implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "_ID")
	private String id;

	@Column(name = "NAME")
	private String name;


	@FieldMapperAnnotation(dbFieldName = "USER_ID", jdbcType = JdbcType.VARCHAR, dbAssociationUniqueKey = "_ID")
	private User user;

	public int getLength(){
		return 0;
	}

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


	public User getUser() {
		return user;
	}

	public void setUser(User newUser) {
		if (this.user == null || !this.user.equals(newUser)) {
			if (this.user != null) {
				User oldPerson = this.user;
				this.user = null;
				oldPerson.removePlan(this);
			}
			if (newUser != null) {
				this.user = newUser;
				this.user.addPlan(this);
			}
		}
	}

}
