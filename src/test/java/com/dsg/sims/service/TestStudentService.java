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
import com.dsg.sims.model.Student;
import com.dsg.sims.common.utils.JeckSonUtils;

/**
 * 学生信息服务测试
 * @author maxiaoding
 */
@RunWith(Parameterized.class)
public class TestStudentService extends BaseTestCase{

	@Autowired
	private StudentService studentService;

	/**
	 * 学生信息
	 */
	private Student student;

	/**
	 * 期望值
	 */
	private String expected;

	public TestStudentService(String expected, Student student) {
		this.expected = expected;
		this.student = student;
	}

	@Parameters
	public static Collection<Object[]> data() throws ParseException, JsonProcessingException {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date myDate = dateFormat.parse("2016-07-19 01:01:01");
		Student student1 = new Student();
		student1.setStudentId("123456789");
		student1.setName("tom");
		student1.setSex("男");
		student1.setBirthday(myDate);
		student1.setCitizenId("500000196601010001");
		student1.setAddress("重庆市北碚区天生路2号");
		student1.setPoliticalStatus("党员");
		student1.setGrade(2014);
		student1.setClassesId(123);
		student1.setSchoolId(456);
		List<Student> list1 = new ArrayList<Student>();
		list1.add(student1);
		String json1 = JeckSonUtils.object2Json(list1);

		Student student2 = new Student();
		student2.setStudentId("456789123");
		student2.setName("tony");
		student2.setSex("女");
		student2.setBirthday(myDate);
		student2.setCitizenId("500000196601010002");
		student2.setAddress("重庆市北碚区天生路2号");
		student2.setPoliticalStatus("团员");
		student2.setGrade(2014);
		student2.setClassesId(123);
		student2.setSchoolId(456);
		List<Student> list2 = new ArrayList<Student>();
		list2.add(student2);
		String json2 = JeckSonUtils.object2Json(list2);

		return Arrays.asList(new Object[][] { { json1, student1 }, { json2, student2 } });
	}

	@Before
	public void beforeAddTest() throws ParseException {
		studentService.addStudent(student);
	}

	@Test
	public void testAdd() throws JsonProcessingException {
		List<Student> list = new ArrayList<Student>();
		list.add(studentService.queryStudentById(student.getStudentId()));
		String json = JeckSonUtils.object2Json(list);
		assertEquals(expected, json);
	}

	@After
	public void afterAddTest() {
		studentService.delStudent(student.getStudentId());
	}
}
