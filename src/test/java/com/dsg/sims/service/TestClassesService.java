package com.dsg.sims.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.dsg.sims.BaseTestCase;
import com.dsg.sims.model.Classes;
import com.dsg.sims.common.utils.JeckSonUtils;

/**
 * 班级信息服务测试
 * @author maxiaoding
 */
@RunWith(Parameterized.class)
public class TestClassesService extends BaseTestCase{

	@Autowired
	private ClassesService classesService;

	/**
	 * 班级信息
	 */
	private Classes classes;

	/**
	 * 期望值
	 */
	private String expected;

	public TestClassesService(String expected, Classes classes) {
		this.expected = expected;
		this.classes = classes;
	}

	@Parameters
	public static Collection<Object[]> data() throws ParseException, JsonProcessingException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date myDate = dateFormat.parse("2016-07-19 01:01:01");
		Classes classes1 = new Classes();
		classes1.setClassesId(123456);
		classes1.setName("tom");
		classes1.setGrade(2014);
		classes1.setTeacher("小王");
		classes1.setSchoolId(456);
		List<Classes> list1 = new ArrayList<Classes>();
		list1.add(classes1);
		String json1 = JeckSonUtils.object2Json(list1);

		Classes classes2 = new Classes();
		classes2.setClassesId(456789);
		classes2.setName("tony");
		classes2.setGrade(2014);
		classes2.setTeacher("大王");
		classes2.setSchoolId(456);
		List<Classes> list2 = new ArrayList<Classes>();
		list2.add(classes2);
		String json2 = JeckSonUtils.object2Json(list2);

		return Arrays.asList(new Object[][] { { json1, classes1 }, { json2, classes2 } });
	}

	@Before
	public void beforeAddTest() throws ParseException {
		classesService.addClasses(classes);
	}

	@Test
	public void testAdd() throws JsonProcessingException {
		List<Classes> list = new ArrayList<Classes>();
		list.add(classesService.queryClassesById(classes.getClassesId()));
		String json = JeckSonUtils.object2Json(list);
		assertEquals(expected, json);
	}

	@After
	public void afterAddTest() {
		classesService.delClasses(classes.getClassesId());
	}
}
