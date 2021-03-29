package com.liantong.integration.mapper;

import com.liantong.integration.pojo.Student;
import com.liantong.integration.pojo.Classes;

import java.util.Collection;

public interface StudentMapper {

	public Student select(Object id);

	public Collection<Student> selectAll(Student t);

	public Student selectOne(Student t);

	public void insert(Student t);

	public int update(Student t);

	public int updatePersistent(Student t);

	public int delete(Student t);

	public int myCount(Student t);

	public void loadClasses(Classes classes, Student student);
}
