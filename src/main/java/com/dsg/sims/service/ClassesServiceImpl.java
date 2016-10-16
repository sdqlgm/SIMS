package com.dsg.sims.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.mapper.ClassesMapper;
import com.dsg.sims.model.Classes;
import com.dsg.sims.model.param.QueryConditionData;

@Service
public class ClassesServiceImpl implements ClassesService {
	@Autowired
	private ClassesMapper classesMapper;
	

	@Override
	public boolean addClasses(Classes classes) {
		return classesMapper.addClasses(classes);
	}

	@Override
	public boolean delClasses(int classesId) {
		return classesMapper.delClasses(classesId);
	}

	@Override
	public boolean updateClasses(Classes classes) {
		return classesMapper.updateClasses(classes);
	}

	@Override
	public Classes queryClassesById(int classesId) {
		return classesMapper.queryClassesById(classesId);
	}

	@Override
	public List<Classes> queryClasses(QueryConditionData queryConditionData, Page page) {
		return classesMapper.queryClasses(queryConditionData, page);
	}

	@Override
	public int queryClassesCount() {
		return classesMapper.queryClassesCount();
	}

	@Override
	public List<Classes> queryBySchoolId(int schoolId) {
		return classesMapper.queryBySchoolId(schoolId);
	}
}
