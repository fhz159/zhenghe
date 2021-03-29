package com.liantong.integration.mapper;

import com.liantong.integration.pojo.Classes;

import java.util.Collection;
import java.util.Map;


public interface ClassesMapper {

	public Classes select(Object id);

	public Collection<Classes> selectAll(Classes t);

	public Classes selectOne(Classes t);

	public void insert(Classes t);

	public int update(Classes t);

	public int updatePersistent(Classes t);

	public int delete(Classes t);

	public int count(Classes t);

	public int updateDirect(Map<String, Object> t);

	public int updateDirectWithoutCache(Map<String, Object> t);
}
