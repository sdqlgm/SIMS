package com.dsg.sims.model;
/**
 * 学院信息模型
 * @author maxiaoding
 */
public class School {
	/**
	 * 学院ID
	 */
	private int schoolId;
	/**
	 * 学院名称
	 */
	private String name;
	public int getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
