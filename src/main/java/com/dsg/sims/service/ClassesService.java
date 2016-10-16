package com.dsg.sims.service;

import java.util.List;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.model.Classes;
import com.dsg.sims.model.param.QueryConditionData;

/**
 * 班级信息Service
 * @author maxiaoding
 */
public interface ClassesService {
	/**
	 * 增加班级信息
	 * @param classes
	 * @return
	 */
	public boolean addClasses(Classes classes);
	/**
	 * 根据班级ID删除班级信息
	 * @param classesId
	 * @return
	 */
	public boolean delClasses(int classesId);
	
	/**
	 * 修改班级信息
	 * @param classes
	 * @return
	 */
	public boolean updateClasses(Classes classes);

	/**
	 * 根据班级ID查询班级信息
	 * @param classesId
	 * @return
	 */
	public Classes queryClassesById(int classesId);
	
	/**
	 * 查询数据库中所有班级信息
	 * @param page 
	 * @param queryConditionData 
	 * @return
	 */
	public List<Classes> queryClasses(QueryConditionData queryConditionData, Page page);
	
	/**
	 * 查询班级数量
	 * @return
	 */
	public int queryClassesCount();
	
	/**
	 * 查询所有schoolId所在学院的所有班级
	 * @param schoolId
	 * @return
	 */
	public List<Classes> queryBySchoolId(int schoolId);
	
}
