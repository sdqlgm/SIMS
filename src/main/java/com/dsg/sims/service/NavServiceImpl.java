package com.dsg.sims.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsg.sims.model.Nav;
import com.dsg.sims.model.School;

@Service
public class NavServiceImpl implements NavService {
	@Autowired
	private ClassesService classesService;

	@Autowired
	private SchoolService schoolService;

	@Override
	public List<Nav> queryNav() {
		List<Nav> ret = new ArrayList<Nav>();
		 List<School> list = schoolService.query();

		for (School item : list) {
			Nav nav = new Nav();
			nav.setSchoolId(item.getSchoolId());
			nav.setName(item.getName());
			nav.setClasses(classesService.queryBySchoolId(item.getSchoolId()));
			ret.add(nav);
		}
		return ret;
	}

}
