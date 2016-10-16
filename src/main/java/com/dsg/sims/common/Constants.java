package com.dsg.sims.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.dsg.sims.common.utils.PropertiesUtils;

/**
 * 常量类
 * author JieChen
 * createTime 11/15/15 4:30 PM
 */
public class Constants {

    /**
     * 信达时间字节长度
     */
    public static final int XDECO_TIME_BYTE_LENGTH = 5;

    /**
     * 数据格式分隔符
     */
    public static final char DATA_FORMAT_SPLITOR = ',';
    
    /**
     * 系统配置文件名称
     */
    public static final String SYSTEMCONFIG_PROPERTIES_NAME = "systemconfig.properties";

    /**
     * 系统是否初始化配置文件key
     */
    public static final String SYSTEM_INITED_PROPERTIES_KEY = "inited";
    
    /**
     * 系统是否初始化Service
     */
    public static boolean SYSTEM_INITED_SERVICE = false;
    
    /**
     * 系统是发送标签原始数据
     */
    public static boolean SEND_MESSAGE = false;
    
    /**
     * 两个L杆之间距离
     */
    public static final int DISTANCE = 100;

    /**
     * Response消息头：消息内容类型KEY
     */
    public static final String HEADER_CONTENT_TYPE_KEY = "Content-type";

    /**
     * Response消息头：消息内容VALUE
     */
    public static final String HEADER_CONTENT_TYPE_VALUE = "text/html;charset=UTF-8";

    /**
     * Response消息编码字符 :UTF-8
     */
    public static final String HEADER_CHARACTER_ENCODING = "UTF-8";

    /**
     * 操作状态：服务器内部错误：500
     */
    public static final int STATE_ERROR_500 = 500;

    /**
     * 操作状态：成功
     */
    public static final int STATE_SUCCESS_200 = 200;
    
    /**
	 * 系统授权
	 */
	public static List<String> SYSTEM_LICENSE_LIST = new ArrayList<>();
    
	/**
     * 行政区划跟节点ID
     */
    public static String REGION_ROOT_ID = null;
    static{
		Properties properties = PropertiesUtils.loadProperties("systemconfig.properties");
		SYSTEM_INITED_SERVICE = Boolean.parseBoolean(String.valueOf(properties.get("initservice")));
		SEND_MESSAGE = Boolean.parseBoolean(String.valueOf(properties.get("sendmessage")));
		String licenses = String.valueOf(properties.get("systemlicense"));
		if(StringUtils.isNotBlank(licenses)){
			for(String license : licenses.split(","))
				SYSTEM_LICENSE_LIST.add(license);
		}
	}
    
    /**
	 * 时间进制
	 */
	public static final long SECEND = 60;

	/**
	 * 每秒毫秒数
	 */
	public static final long SECEND_MILLIS = 1000;

	/**
	 *百分制 
	 */
	public static final int HUNDRED = 100;

	/**
	 * 保留小数位
	 */
	public static final int RESERVED_DECIMAL = 2;
	
	/**
	 * 新增列族
	 */
	public static final String ADD_COLUMN = "addColumn";
	/**
	 * 删除列族
	 */
	public static final String DELET_COLUMN = "deleteColumn";
	/**
	 * 修改列族
	 */
	public static final String UPDATE_COLUMN = "updateColumn";
	
	public static void main(String[] args) {
		System.out.println(Constants.SYSTEM_INITED_SERVICE);
		System.out.println(Constants.SYSTEM_LICENSE_LIST);
	}
    
    
    
}
