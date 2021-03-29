package com.liantong.integration.mapper;

import com.liantong.integration.pojo.Keyword;

import java.util.Collection;

public interface KeywordMapper {

    public Keyword select(Object id);

    public Keyword selectOne(Keyword keyword);

    public void insert(Keyword keyword);

    public int update(Keyword keyword);

    public int delete(Keyword keyword);

    public int count(Keyword keyword);

    public Collection<Keyword> selectAll(Keyword keyword);

}