package com.dsg.sims.common.utils;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 配置文件工具类
 * author JieChen
 * createTime 11/15/15 4:35 PM
 */
public final class PropertiesUtils {
	
	private static Logger log = LoggerFactory.getLogger(PropertiesUtils.class);
	
	private PropertiesUtils(){
		
	}

	/**
	 *  读取配置文件<br>
	 *  需要做判空处理<br>
	 * @author chenjie
	 * 2014-5-1 上午6:27:17
	 * @param propertiesFileName 配置文件名称
	 * @return Properties
	 */
	public static final Properties loadProperties(String propertiesFileName){
		if(StringUtils.isBlank(propertiesFileName))
			return null;
		Properties propes = null;
		InputStream inputStream = null;
		try{
			log.info(propertiesFileName);
			inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(propertiesFileName);
			if(null == inputStream){
				throw new FileNotFoundException();
			}
			propes = new Properties();
			propes.load(inputStream);
		}catch (FileNotFoundException e) {
			log.info("Can't found properties file "+propertiesFileName+":"+e.getMessage());
		}catch (IOException e) {
			log.info("Can't load properties file "+propertiesFileName+":"+e.getMessage());
		}finally{
			IOUtils.closeQuietly(inputStream);
		}
		return propes;
	}

	/**
	 * 获取配置属性
	 * @param propertiesFileName 配置文件名称
	 * @param key 配置属性key
	 * @return String
	 * @throws IOException
	 */
	public static String getProperty(final String propertiesFileName,final String key) throws IOException {
		String value = "";
		if(StringUtils.isBlank(propertiesFileName) || StringUtils.isBlank(key))
			return value;
		Properties pro = loadProperties(propertiesFileName);
		if (null != pro)
			value = pro.getProperty(key);
		return value;
	}

	/**
	 * 写配置文件
	 * @param propertiesFileName 配置文件名称
	 * @param map 配置map键值
	 * @throws IOException
	 */
	public static void setProperties(final String propertiesFileName,final Map<String,String> map) throws IOException {
		if(StringUtils.isBlank(propertiesFileName) || null == map || map.size() == 0)
			return;
		BufferedWriter bufferedWriter = null;
		try {
			Properties properties = loadProperties(propertiesFileName);
			if(null == properties)
				return;
			URL fileUrl = PropertiesUtils.class.getClassLoader().getResource(propertiesFileName);
			if(null == fileUrl)
				return;
			String filePath = fileUrl.getFile();
			File file = new File(filePath);
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			for(String key : map.keySet())
				properties.setProperty(key , map.get(key));
			properties.store(bufferedWriter,"");
		}finally {
			IOUtils.closeQuietly(bufferedWriter);
		}
	}

	public static void main(String[] args) throws IOException {
		Properties pro = loadProperties("systemconfig.properties");
		if (pro != null) {
			System.out.println(pro.getProperty("inited"));
		}
		Map<String,String> map = new HashMap<>();
		map.put("inited","true");
		setProperties("systemconfig.properties", map);

	}



}
