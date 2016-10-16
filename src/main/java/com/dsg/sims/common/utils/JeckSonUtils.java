package com.dsg.sims.common.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JECKSON工具类
 * author JieChen
 * createTime 3/14/16 9:13 PM
 */
public class JeckSonUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象转换成JSON
     * @param object 需要转换的对象
     * @return jsong字符串
     * @throws JsonProcessingException
     */
    public static String object2Json(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * json转换成对象
     * @param jeson json字符串
     * @param clazz 对象类
     * @return Object
     * @throws IOException
     */
	public static Object json2Object(String jeson,Class<?> clazz) throws IOException {
        return objectMapper.readValue(jeson,clazz);
    }


}
