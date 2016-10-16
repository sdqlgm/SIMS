package com.dsg.sims.model.param;

import java.util.Date;

/**
 * 搜索下拉框查询参数类
 * @author jianpeng
 * @createTime 2016年8月1日 上午9:47:17
 */
public class QueryConditionData {

	/**
	 * 当前页
	 */
	private int currentPage;

	/**
	 * 当前页显示记录条数
	 */
	private int pageSize;

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
	private String grade;
	/**
	 * 外键，学院ID
	 */
	private String schoolId;
	
	/**
	 * 出生日期的开始日期
	 */
	private String startTime;
	/**
	 * 出生日期的结束日期
	 */
	private String endTime;
	/**
	 * 班级ID
	 */
	private String classesId;
	
	
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
	public String getGrade() {
		return grade;
	}
	public String getSchoolId() {
		return schoolId;
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
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getClassesId() {
		return classesId;
	}
	public void setClassesId(String classesId) {
		this.classesId = classesId;
	}

}
