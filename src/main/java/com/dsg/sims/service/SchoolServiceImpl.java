package com.dsg.sims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.mapper.SchoolMapper;
import com.dsg.sims.model.School;
import com.dsg.sims.model.param.QueryConditionData;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	private SchoolMapper schoolMapper;
	

	@Override
	public boolean addSchool(School school) {
		return schoolMapper.addSchool(school);
	}

	@Override
	public boolean delSchool(int schoolId) {
		return schoolMapper.delSchool(schoolId);
	}

	@Override
	public boolean updateSchool(School school) {
		return schoolMapper.updateSchool(school);
	}

	@Override
	public School querySchoolById(int schoolId) {
		return schoolMapper.querySchoolById(schoolId);
	}

	@Override
	public List<School> queryClasses(QueryConditionData queryConditionData, Page page) {
		return schoolMapper.querySchool(queryConditionData, page);
	}

	@Override
	public int querySchoolCount() {
		return schoolMapper.querySchoolCount();
	}

	@Override
	public List<School> query() {
		return schoolMapper.query();
	}
}