package com.liantong.integration.service;

import java.util.Collection;
import java.util.Map;

import com.liantong.integration.mapper.ClassesMapper;
import com.liantong.integration.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClassesService implements ClassesMapper {

	@Autowired
	private ClassesMapper mapper;

	@Override
	public Classes select(Object id) {
		return mapper.select(id);
	}

	@Override
	public Collection<Classes> selectAll(Classes t) {
		return mapper.selectAll(t);
	}

	@Override
	public Classes selectOne(Classes t) {
		return mapper.selectOne(t);
	}

	@Override
	public void insert(Classes t) {
		mapper.insert(t);
	}

	@Override
	public int update(Classes t) {
		return mapper.update(t);
	}

	@Override
	public int updatePersistent(Classes t) {
		return mapper.updatePersistent(t);
	}

	@Override
	public int delete(Classes t) {
		return mapper.delete(t);
	}

	@Override
	public int count(Classes t) {
		return mapper.count(t);
	}

	@Override
	public int updateDirectWithoutCache(Map<String, Object> t) {
		return mapper.updateDirectWithoutCache(t);
	}

	@Override
	public int updateDirect(Map<String, Object> t) {
		return mapper.updateDirect(t);
	}

}
