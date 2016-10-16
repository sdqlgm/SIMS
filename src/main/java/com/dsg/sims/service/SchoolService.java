package com.dsg.sims.service;

import java.util.List;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.model.School;
import com.dsg.sims.model.param.QueryConditionData;

/**
 * 学院信息Service
 * @author maxiaoding
 */
public interface SchoolService {
	/**
	 * 增加学院信息
	 * @param school
	 * @return
	 */
	public boolean addSchool(School school);
	/**
	 * 根据学院ID删除学院信息
	 * @param schoolId
	 * @return
	 */
	public boolean delSchool(int schoolId);
	
	/**
	 * 修改学院信息
	 * @param school
	 * @return
	 */
	public boolean updateSchool(School school);

	/**
	 * 根据学院ID查询学院信息
	 * @param schoolId
	 * @return
	 */
	public School querySchoolById(int schoolId);
	
	/**
	 * 查询数据库中所有学院信息
	 * @param page 
	 * @param queryConditionData 
	 * @return
	 */
	public List<School> queryClasses(QueryConditionData queryConditionData, Page page);
	
	/**
	 * 查询学院数量
	 * @return
	 */
	public int querySchoolCount();
	
	public List<School> query();
	
}