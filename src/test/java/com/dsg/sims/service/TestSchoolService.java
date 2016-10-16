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
import com.dsg.sims.model.School;
import com.dsg.sims.common.utils.JeckSonUtils;

/**
 * 学院信息服务测试
 * @author maxiaoding
 */
@RunWith(Parameterized.class)
public class TestSchoolService extends BaseTestCase{

	@Autowired
	private SchoolService schoolService;

	/**
	 * 学院信息
	 */
	private School school;

	/**
	 * 期望值
	 */
	private String expected;

	public TestSchoolService(String expected, School school) {
		this.expected = expected;
		this.school = school;
	}

	@Parameters
	public static Collection<Object[]> data() throws ParseException, JsonProcessingException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date myDate = dateFormat.parse("2016-07-19 01:01:01");
		School school1 = new School();
		school1.setSchoolId(5099);
		school1.setName("计算机与信息科学学院");
		List<School> list1 = new ArrayList<School>();
		list1.add(school1);
		String json1 = JeckSonUtils.object2Json(list1);

		School school2 = new School();
		school2.setSchoolId(5089);
		school2.setName("物理学院");
		List<School> list2 = new ArrayList<School>();
		list2.add(school2);
		String json2 = JeckSonUtils.object2Json(list2);

		return Arrays.asList(new Object[][] { { json1, school1 }, { json2, school2 } });
	}

	@Before
	public void beforeAddTest() throws ParseException {
		schoolService.addSchool(school);
	}

	@Test
	public void testAdd() throws JsonProcessingException {
		List<School> list = new ArrayList<School>();
		list.add(schoolService.querySchoolById(school.getSchoolId()));
		String json = JeckSonUtils.object2Json(list);
		assertEquals(expected, json);
	}

	@After
	public void afterAddTest() {
		schoolService.delSchool(school.getSchoolId());
	}
}