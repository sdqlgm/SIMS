package com.dsg.sims.model;

import java.util.List;

/**
 * 导航条信息
 * 包含学院和学院所有的班级
 * @author maxiaoding
 */
public class Nav {
	/**
	 * 学院ID
	 */
	private int schoolId;
	/**
	 * 学院名称
	 */
	private String name;
	
	/**
	 * 学院中所有的班级列表
	 */
	private List<Classes> classes;

	
	
	public int getSchoolId() {
		return schoolId;
	}

	public String getName() {
		return name;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}
	
	
}
