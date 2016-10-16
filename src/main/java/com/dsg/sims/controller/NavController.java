package com.dsg.sims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsg.sims.common.spring.BaseController;
import com.dsg.sims.model.Nav;
import com.dsg.sims.model.Student;
import com.dsg.sims.service.NavService;

/**
 * 导航条信息
 * 
 * @author maxiaoding
 */
@Controller
@RequestMapping("/navInfo")
public class NavController extends BaseController {
	@Autowired
	private NavService navService;

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public Model query() {
		Model model = new ExtendedModelMap();

		List<Nav> list = navService.queryNav();
		
		model.addAttribute("navInfo", list);
		return model;
	}

}
