package com.dsg.sims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsg.sims.common.spring.BaseController;
import com.dsg.sims.model.Classes;
import com.dsg.sims.model.Student;
import com.dsg.sims.model.param.QueryConditionData;
import com.dsg.sims.service.ClassesService;
import com.dsg.sims.service.NavService;

/**
 * 导航条信息
 * 
 * @author maxiaoding
 */
@Controller
@RequestMapping("/classesInfo")
public class ClassesController extends BaseController {
	@Autowired
	private ClassesService classesService;

	/**
	 * 
	 * @param queryConditionData
	 * @return
	 */
	@RequestMapping(value = "/queryByClassesId", method = RequestMethod.GET)
	public Model queryByClassesId(QueryConditionData queryConditionData) {
		Model model = new ExtendedModelMap();

		Classes classes = classesService.queryClassesById(Integer.valueOf(queryConditionData.getClassesId()));		
		model.addAttribute("classesInfo", classes);
		return model;
	}

}
