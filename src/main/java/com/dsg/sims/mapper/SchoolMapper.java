package com.dsg.sims.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.model.School;
import com.dsg.sims.model.param.QueryConditionData;
/**
 * 学院信息mapper
 * @author maxiaoding
 */
public interface SchoolMapper {

	boolean addSchool(School school);
	
	boolean delSchool(int schoolId);

	boolean updateSchool(School school);

	School querySchoolById(int schoolId);
	
	List<School> querySchool(@Param("queryConditionData")QueryConditionData queryConditionData,Page page);

	int querySchoolCount();

	List<School> query();

}
