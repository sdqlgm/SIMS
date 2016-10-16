package com.dsg.sims.model;

import java.util.Date;

/**
 * 学生信息模型
 * @author maxiaoding
 */
public class Student {
	/**
	 * 学生ID
	 */
	private String studentId;
	/**
	 * 学生姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 身份证号
	 */
	private String citizenId;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 政治面貌：党员、团员、少先队员、群众
	 */
	private String politicalStatus;
	/**
	 * 年级
	 */
	private int grade;
	/**
	 * 外键，班级ID
	 */
	private int classesId;
	/**
	 * 外键，学院ID
	 */
	private int schoolId;
	public String getStudentId() {
		return studentId;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getCitizenId() {
		return citizenId;
	}
	public String getAddress() {
		return address;
	}
	public String getPoliticalStatus() {
		return politicalStatus;
	}
	public int getGrade() {
		return grade;
	}
	public int getClassesId() {
		return classesId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setCitizenId(String citizenId) {
		this.citizenId = citizenId;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPoliticalStatus(String politicalStatus) {
		this.politicalStatus = politicalStatus;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
}
