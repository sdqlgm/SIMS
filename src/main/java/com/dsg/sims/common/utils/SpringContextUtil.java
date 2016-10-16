package com.dsg.sims.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * @ClassName: SpringContextUtil 
 * @Description: SpringApplicationContext工具类
 * @author zhuzehong
 * @date 2015年12月3日 下午3:22:11 
 *
 */
@Service
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextUtil.applicationContext = applicationContext;
	}

	/**
	 * 
	 * @Title: getApplicationContext 
	 * @Description: 获取SpringApplicationContext上下文 
	 * @return ApplicationContext    返回类型 
	 * @throws
	 */
	public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
	
	/**
	 * 
	 * @Title: getBean 
	 * @Description: 根据服务名称获取Bean 
	 * @param beanName
	 * @return Object    返回类型 
	 * @throws
	 */
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
     
    /**
     * 
     * @Title: getBean 
     * @Description: 根据服务名称和服务Class获取Bean  
     * @param beanName
     * @param clazz
     * @return T    返回类型 
     * @throws
     */
    public static <T>T getBean(String beanName , Class<T>clazz) {
        return applicationContext.getBean(beanName , clazz);
    }
}
