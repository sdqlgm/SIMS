package com.dsg.sims.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.dom4j.Attribute;
import org.dom4j.Element;

/**
 * XML文件解析工具类
 * author chenjie
 * date 2015-11-15 下午02:13:07
 */
public final class XmlUtils {
	
	private XmlUtils(){
		
	}

	/**
	 * 读取配置文件信息
	 * 
	 * @param configFileName 配置文件名称
	 * @return String
	 * @throws IOException
	 * @throws UnsupportedEncodingException
	 */
	public static String getXMLConfig(String configFileName) throws IOException {
		InputStream in = null;
		StringBuilder xmlSb = null;
		try {
			in = XmlUtils.class.getClassLoader().getResourceAsStream(configFileName);
			xmlSb = new StringBuilder();
			byte[] b = new byte[1024];
			int i;
			while ((i = in.read(b)) != -1) {
				xmlSb.append(new String(b, 0, i, "UTF-8"));
			}
		} finally {
			IOUtils.closeQuietly(in);
		}
		return xmlSb.toString();
	}

	/**
	 * 获取节点值
	 * 
	 * @param element 元素
	 * @param nodeName 节点名称
	 * @return String
	 */
	public static String getElementData(Element element, String nodeName) {
		Element node = element.element(nodeName);
		if (null == node)
			return "";
		Object object = node.getData();
		if (null == object)
			return "";
		return object.toString();
	}

	/**
	 * 获取节点所有属性
	 * @param element 元素
	 * @return Map
	 */
	public static Map<String, String> getNodeAttribute(Element element) {
		if (element == null)
			return null;
		Map<String, String> attributemMap = new HashMap<String, String>();
		Iterator<?> itAttribute = element.attributeIterator();
		if(itAttribute==null)
			return null;
		while (itAttribute.hasNext()) {
			Attribute attribute = (Attribute) itAttribute.next();
			attributemMap.put(attribute.getName(), attribute.getValue());
		}
		return attributemMap;
	}



}
