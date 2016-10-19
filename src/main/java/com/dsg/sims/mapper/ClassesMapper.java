package com.dsg.sims.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.model.Classes;
import com.dsg.sims.model.param.QueryConditionData;

/**
 * 学生信息mapper
 * @author maxiaoding
 */
@Repository
public interface ClassesMapper {

	boolean addClasses(Classes classes);
	
	boolean delClasses(int classesId);

	boolean updateClasses(Classes classes);

	Classes queryClassesById(int classesId);
	
	List<Classes> queryClasses(@Param("queryConditionData")QueryConditionData queryConditionData,Page page);

	int queryClassesCount();

	List<Classes> queryBySchoolId(int schoolId);

}
