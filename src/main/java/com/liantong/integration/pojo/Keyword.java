package com.liantong.integration.pojo;

import indi.mybatis.flying.annotations.FieldMapperAnnotation;
import org.apache.ibatis.type.JdbcType;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "KEYWORD")
public class Keyword  implements Serializable {

    private static final long serialVersionUID = 1L;

    @FieldMapperAnnotation(dbFieldName = "id", jdbcType = JdbcType.INTEGER, isUniqueKey = true)
    private Integer id;

    @FieldMapperAnnotation(dbFieldName = "name", jdbcType = JdbcType.VARCHAR)
    private String name;

    @FieldMapperAnnotation(dbFieldName = "bid", jdbcType = JdbcType.INTEGER)
    private Integer bid;

/*    @FieldMapperAnnotation(dbFieldName = "user_id", jdbcType = JdbcType.VARCHAR, dbAssociationUniqueKey = "id")
    private User user;*/

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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

/*    public void setUser(User newUser) {
        if (this.user == null || !this.user.equals(newUser)) {
            if (this.user != null) {
                User oldUser = this.user;
                this.user = null;
                oldUser.removeKeyword(this);
            }
            if (newUser != null) {
                this.user = newUser;
                this.user.addKeyword(this);
            }
        }
    }*/
}
