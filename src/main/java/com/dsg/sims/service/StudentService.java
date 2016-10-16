package com.dsg.sims.service;

import java.util.List;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.model.Student;
import com.dsg.sims.model.param.QueryConditionData;

/**
 * 学生信息服务接口
 * @author maxiaoding
 */
public interface StudentService {
	/**
	 * 增加学生信息
	 * @param student
	 * @return
	 */
	public boolean addStudent(Student student);
	/**
	 * 根据学生ID删除学生信息
	 * @param studentId
	 * @return
	 */
	public boolean delStudent(String studentId);
	
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 */
	public boolean updateStudent(Student student);

	/**
	 * 根据学生ID查询学生信息
	 * @param studentId
	 * @return
	 */
	public Student queryStudentById(String studentId);
	
	/**
	 * 查询数据库中所有学生信息
	 * @param page 
	 * @param queryConditionData 
	 * @return
	 */
	public List<Student> queryStudent(QueryConditionData queryConditionData, Page page);
	
	/**
	 * 查询学生数量
	 * @return
	 */
	public int queryStudentCount();
	
	/**
	 * 根据参数动态查询学生信息
	 * @param student
	 * @return
	 */
	public List<Student> queryStudent(QueryConditionData student);
}
