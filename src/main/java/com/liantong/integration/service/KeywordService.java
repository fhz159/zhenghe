package com.liantong.integration.service;

import com.liantong.integration.mapper.KeywordMapper;
import com.liantong.integration.pojo.Keyword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KeywordService implements KeywordMapper {

    @Autowired
    private KeywordMapper keywordMapper;

    @Override
    public Keyword select(Object id) {
        return keywordMapper.select(id);
    }

    @Override
    public Keyword selectOne(Keyword keyword) {
        return keywordMapper.selectOne(keyword);
    }

    @Override
    public void insert(Keyword keyword) {
        keywordMapper.insert(keyword);
    }

    @Override
    public int update(Keyword keyword) {
        return keywordMapper.update(keyword);
    }

    @Override
    public int delete(Keyword keyword) {
        return keywordMapper.delete(keyword);
    }

    @Override
    public int count(Keyword keyword) {
        return keywordMapper.count(keyword);
    }

    @Override
    public Collection<Keyword> selectAll(Keyword keyword) {
        return keywordMapper.selectAll(keyword);
    }


}
