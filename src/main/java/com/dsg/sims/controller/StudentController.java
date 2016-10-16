package com.dsg.sims.controller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsg.sims.common.model.Page;
import com.dsg.sims.common.spring.BaseController;
import com.dsg.sims.common.utils.SystemUtils;
import com.dsg.sims.model.Student;
import com.dsg.sims.model.param.QueryConditionData;
import com.dsg.sims.service.StudentService;

/**
 * 学生信息Controller
 * 
 * @author maxiaoding
 */
@Controller
@RequestMapping("/studentInfo")
public class StudentController extends BaseController {
	@Autowired
	private StudentService studentService;

	/**
	 * 修改一条学生信息
	 * 
	 * @param queryConditionData
	 * @return
	 */
	@RequestMapping(value = "/updateStudentInfo", method = RequestMethod.GET)
	public Model updateStudentInfo(Student student) {
		Model model = new ExtendedModelMap();
		boolean isok = false;
		try {
			isok = studentService.updateStudent(student);
			model.addAttribute("isok", isok);
		} catch (Exception e) {
			model.addAttribute("isok", false);
		}
		return model;
	}

	/**
	 * 删除一条学生信息
	 * 
	 * @param queryConditionData
	 * @return
	 */
	@RequestMapping(value = "/deleteStudentInfo", method = RequestMethod.GET)
	public Model deleteStudentInfo(String studentId) {
		Model model = new ExtendedModelMap();
		boolean isok = false;
		try {
			isok = studentService.delStudent(studentId);
			model.addAttribute("isok", isok);
		} catch (Exception e) {
			model.addAttribute("isok", false);
		}
		return model;
	}

	/**
	 * 添加一条学生信息
	 * 
	 * @param queryConditionData
	 * @return
	 */
	@RequestMapping(value = "/addStudentInfo", method = RequestMethod.GET)
	public Model addStudentInfo(Student student) {
		Model model = new ExtendedModelMap();
		boolean isok = false;
		try {
			isok = studentService.addStudent(student);
			model.addAttribute("isok", isok);
		} catch (Exception e) {
			model.addAttribute("isok", false);
		}
		return model;
	}

	/**
	 * 查询所有学生信息
	 * 
	 * @param queryConditionData
	 * @return
	 */
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public Model query(QueryConditionData queryConditionData) {
		Page page = new Page(queryConditionData);
		Model model = new ExtendedModelMap();

		List<Student> list = studentService.queryStudent(queryConditionData, page);

		model.addAttribute("studentInfo", list);
		model.addAttribute("total", page.getCount());
		model.addAttribute("currentPage", page.getPage());
		model.addAttribute("pages", page.getPages());
		return model;
	}

	/**
	 * 根据参数中的条件查询学生信息
	 * 例如，paramName="name" value="tom" classesId="1002"
	 * 查询1002班中姓名为tom的所有人
	 * @param queryConditionData
	 * @return
	 */
	@RequestMapping(value = "/queryDynamic", method = RequestMethod.GET)
	public Model queryByStudentId(String paramName, String value, String classesId) {
		Model model = new ExtendedModelMap();
		QueryConditionData studentParam = new QueryConditionData();
		studentParam.setClassesId(classesId);

		// 使用反射来将参数注入对应的参数名中
		Method method = null;
		try {
			String methodName = "set" + paramName.substring(0, 1).toUpperCase()
					+ paramName.substring(1, paramName.length());
			method = studentParam.getClass().getMethod(methodName, String.class);
			method.invoke(studentParam, value);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			model.addAttribute("list", "");
			return model;
		}

		// 模糊查询
		List<Student> list = studentService.queryStudent(studentParam);
		model.addAttribute("list", list);
		return model;
	}

	/**
	 * 将前端传回的字符串自动转换成Date型
	 * 
	 * @param binder
	 */
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

}
