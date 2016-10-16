package com.dsg.sims.service;

import java.util.List;

import com.dsg.sims.model.Nav;

/**
 * 导航条的服务
 * 查询学院和对应的班级
 * @author maxiaoding
 */
public interface NavService {
	/**
	 * 查询导航条信息
	 * 包含所有学院和班级信息
	 * @return
	 */
	public List<Nav> queryNav();
	
}
