package com.dsg.sims.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.model.Student;
import com.dsg.sims.model.param.QueryConditionData;

/**
 * 学生信息mapper
 * @author maxiaoding
 */
public interface StudentMapper {

	boolean addStudent(Student student);
	
	boolean delStudent(String studentId);

	boolean updateStudent(Student student);

	Student queryStudentById(String studentId);
	
	List<Student> queryStudent(@Param("queryConditionData")QueryConditionData queryConditionData,Page page);

	int queryStudentCount();

	List<Student> queryStudentParam(QueryConditionData student);
}
