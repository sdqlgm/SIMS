package com.dsg.sims.model;

/**
 * 班级类
 * @author maxiaoding
 */
public class Classes {
	/**
	 * 班级ID
	 */
	private int classesId;
	/**
	 * 班级名称
	 */
	private String name;
	/**
	 * 年级
	 */
	private int grade;
	/**
	 * 老师姓名
	 */
	private String teacher;
	/**
	 * 学院ID
	 */
	private int schoolId;
	
	public int getClassesId() {
		return classesId;
	}
	public String getName() {
		return name;
	}
	public int getGrade() {
		return grade;
	}
	public String getTeacher() {
		return teacher;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	
}
