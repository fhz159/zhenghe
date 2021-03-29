package com.liantong.integration.mapper;

import com.liantong.integration.pojo.Keyword;
import com.liantong.integration.pojo.Look;

import java.util.Collection;

public interface LookMapper {
    public Look select(Object id);

    public Look selectOne(Look look);

    public void insert(Look look);

    public int update(Look look);

    public int delete(Look look);

    public int count(Look look);

    public Collection<Look> selectAll(Look look);

}
