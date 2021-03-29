package com.liantong.integration.service;

import java.util.Collection;

import com.liantong.integration.mapper.StudentMapper;
import com.liantong.integration.pojo.Student;
import com.liantong.integration.pojo.Classes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentMapper {

	@Autowired
	private StudentMapper mapper;

	@Override
	public Student select(Object id) {
		return mapper.select(id);
	}

	@Override
	public Collection<Student> selectAll(Student t) {
		return mapper.selectAll(t);
	}

	@Override
	public Student selectOne(Student t) {
		return mapper.selectOne(t);
	}

	@Override
	public void insert(Student t) {
		mapper.insert(t);
	}

	@Override
	public int update(Student t) {
		return mapper.update(t);
	}

	@Override
	public int updatePersistent(Student t) {
		return mapper.updatePersistent(t);
	}

	@Override
	public int delete(Student t) {
		return mapper.delete(t);
	}

	@Override
	public int myCount(Student t) {
		return mapper.myCount(t);
	}

	@Override
	public void loadClasses(Classes classes, Student student) {
		classes.removeAllStudent();
		student.setClasses(classes);
		classes.setStudents(mapper.selectAll(student));
	}

}
