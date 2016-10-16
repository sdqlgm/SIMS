package com.dsg.sims.common.spring;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.dsg.sims.common.Constants;
import com.dsg.sims.common.utils.PropertiesUtils;

/**
 * spring上下文加载监听器
 * author JieChen
 * createTime 1/18/16 10:59 PM
 */
public class ContextLoaderListener extends ContextLoader implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(ContextLoaderListener.class);


    public ContextLoaderListener() {
    }

    public ContextLoaderListener(WebApplicationContext context) {
        super(context);
    }

    /**
     * 初始化web容器
     *
     * @param event servlet容器
     */
    public void contextInitialized(ServletContextEvent event) {
        if (getInitedConfig())
            this.initWebApplicationContext(event.getServletContext());
    }

    /**
     * 销毁web容器
     *
     * @param event servlet容器
     */
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        this.closeWebApplicationContext(sc);
        Enumeration attrNames = sc.getAttributeNames();
        while (attrNames.hasMoreElements()) {
            String attrName = (String) attrNames.nextElement();
            if (attrName.startsWith("org.springframework.")) {
                Object attrValue = sc.getAttribute(attrName);
                if (attrValue instanceof DisposableBean) {
                    try {
                        ((DisposableBean) attrValue).destroy();
                    } catch (Throwable var5) {
                        logger.error("Couldn\'t invoke destroy method of attribute with name \'" + attrName + "\'", var5);
                    }
                }
            }
        }
    }

    /**
     * 获取系统初始化信息
     *
     * @return boolean
     */
    public static boolean getInitedConfig() {
        boolean inited = false;
        try {
            String value = PropertiesUtils.getProperty(Constants.SYSTEMCONFIG_PROPERTIES_NAME, Constants.SYSTEM_INITED_PROPERTIES_KEY);
            if (StringUtils.isBlank(value))
                return false;
            inited = Boolean.parseBoolean(value);
        } catch (IOException e) {
        	logger.error(e.getMessage());
        }
        return inited;
    }
}
