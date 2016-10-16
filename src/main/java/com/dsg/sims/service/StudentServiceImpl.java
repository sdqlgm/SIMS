package com.dsg.sims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsg.sims.mapper.StudentMapper;
import com.dsg.sims.model.Student;
import com.dsg.sims.common.model.Page;
import com.dsg.sims.model.param.QueryConditionData;

/**
 * 学生信息服务接口实现类
 * @author maxiaoding
 */
@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;
	

	@Override
	public boolean addStudent(Student student) {
		return studentMapper.addStudent(student);
	}

	@Override
	public boolean delStudent(String studentId) {
		return studentMapper.delStudent(studentId);
	}

	@Override
	public boolean updateStudent(Student student) {
		return studentMapper.updateStudent(student);
	}

	@Override
	public Student queryStudentById(String studentId) {
		return studentMapper.queryStudentById(studentId);
	}

	@Override
	public List<Student> queryStudent(QueryConditionData queryConditionData, Page page) {
		return studentMapper.queryStudent(queryConditionData, page);
	}

	@Override
	public int queryStudentCount() {
		return studentMapper.queryStudentCount();
	}

	@Override
	public List<Student> queryStudent(QueryConditionData student) {
		return studentMapper.queryStudentParam(student);
	}

}
