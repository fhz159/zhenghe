package com.liantong.integration.service;

import com.liantong.integration.mapper.LookMapper;
import com.liantong.integration.pojo.Look;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class LookService implements LookMapper {

    @Autowired
    private  LookMapper lookMapper;

    @Override
    public Look select(Object id) {
        return lookMapper.select(id);
    }

    @Override
    public Look selectOne(Look look) {
        return lookMapper.selectOne(look);
    }

    @Override
    public void insert(Look look) {
lookMapper.insert(look);
    }

    @Override
    public int update(Look look) {
        return lookMapper.update(look);
    }

    @Override
    public int delete(Look look) {
        return lookMapper.delete(look);
    }

    @Override
    public int count(Look look) {
        return lookMapper.count(look);
    }

    @Override
    public Collection<Look> selectAll(Look look) {
        return lookMapper.selectAll(look);
    }
}
