package com.dsg.sims.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSON 工具类
 * @author JieChen
 * @createTime 11/15/15 4:35 PM
 */
public final class JsonUtils {

	private JsonUtils() {

	}

	/**
	 * 获取json节点对象
	 * @author chenjie
	 * @date 2015-3-19 下午04:50:04
	 * @param jsonObject
	 * @param nodeName
	 */
	public static JSONObject getJsonObject(JSONObject jsonObject, String nodeName) {
		if(StringUtils.isBlank(nodeName))
			return null;
		jsonObject = jsonObject.getJSONObject(nodeName);
		return jsonObject;
	}

	/**
	 * 获取json节点对象
	 * @author chenjie
	 * @date 2015-3-19 下午04:50:04
	 * @param json
	 * @param nodeName
	 */
	public static JSONObject getJsonObject(String json, String nodeName) {
		if(StringUtils.isBlank(nodeName))
			return null;
		JSONObject jsonObject = JSONObject.fromObject(json);
		jsonObject = jsonObject.getJSONObject(nodeName);
		return jsonObject;
	}

	/**
	 * 获取json数据中指定字段的只
	 * @author chenjie
	 * @date 2015-3-17 下午07:34:10
	 * @param json
	 * @param fieldName
	 * @return
	 */
	public static String getJsonString(String json,String fieldName){
		JSONObject jsonObject = JSONObject.fromObject(json);
		return String.valueOf(jsonObject.getString(fieldName));
	}

	/**
	 * 将Json对象转换为List
	 * 
	 * @author chenjie
	 * @date 2015-1-23 下午04:15:24
	 * @param jsonString
	 * @param pojoClass
	 * @return List<Object>
	 */
	public static List<? extends Object> json2List(String jsonString, Class<? extends Object> pojoClass) {
		if (StringUtils.isBlank(jsonString))
			return null;
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		Object pojoValue;
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < jsonArray.size(); i++) {
			jsonObject = jsonArray.getJSONObject(i);
			pojoValue = JSONObject.toBean(jsonObject, pojoClass);
			list.add(pojoValue);
		}
		return list;
	}

	/**
	 * json字符串转换为Map对象
	 * 
	 * @author chenjie
	 * @date 2015-1-23 下午04:34:16
	 * @param jsonStr
	 * @return Map<String, Object>
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, ? extends Object> json2Map(String jsonStr) {
		if (StringUtils.isBlank(jsonStr))
			return null;
		Map<String, Object> map = new HashMap<String, Object>();
		// 最外层解析
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			// 如果内层还是数组的话，继续解析
			if (v instanceof JSONArray) {
				List<Map<String, ? extends Object>> list = new ArrayList<Map<String, ? extends Object>>();
				Iterator<JSONObject> it = ((JSONArray) v).iterator();
				while (it.hasNext()) {
					JSONObject json2 = it.next();
					list.add(json2Map(json2.toString()));
				}
				map.put(k.toString(), list);
			} else {
				map.put(k.toString(), v);
			}
		}
		return map;
	}

	/**
	 * json字符串转换为Map对象
	 * 
	 * @author chenjie
	 * @date 2015-1-23 下午04:34:16
	 * @param jsonStr
	 * @return Map<String, Object>
	 */
	public static Map<String, ? extends Object> json2MapWithOutChildren(String jsonStr) {
		if (StringUtils.isBlank(jsonStr))
			return null;
		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = JSONObject.fromObject(jsonStr);
		for (Object k : json.keySet()) {
			Object v = json.get(k);
			map.put(k.toString(), v);
		}
		return map;
	}

	/**
	 * 将Json字符串转换为Object对象
	 * 
	 * @author chenjie
	 * @date 2015-1-23 下午04:10:02
	 * @param jsonString
	 * @param pojoCalss
	 * @return Object
	 */
	public static Object json2Object(String jsonString, Class<? extends Object> pojoCalss) {
		if (StringUtils.isBlank(jsonString))
			return null;
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		Object pojo = JSONObject.toBean(jsonObject, pojoCalss);
		return pojo;
	}
	
	/**
	 * 将列表转换为Json字符串
	 * 
	 * @author chenjie
	 * @date 2015-1-23 下午04:19:39
	 * @param objectList
	 * @return String
	 */
	public static String list2Json(List<? extends Object> objectList) {
		if (null == objectList)
			return null;
		JSONArray jsonArray = JSONArray.fromObject(objectList);
		return jsonArray.toString();
	}
	
	/*public static void main(String[] args) {
		String json = "{\"bpmNodesInfo\":{\"1\":{\"assignmentState\":0,\"boInfo\":{ \"selected\": [], \"items\": [], \"@metadata\":{\"objectID\":\"c29f4111-2f40-4a7a-8435-01381d84e87d\",\"dirty\":false,\"shared\":false}},\"formDefineUUID\":\"FORM201405231505479668\",\"isFreeAppreciation\":0,\"milepostNode\":0,\"nextNumbers\":{ \"selected\": [], \"items\": [\"4\"], \"@metadata\":{\"objectID\":\"5ea1bcf0-f50e-4f21-ae8b-94f3ab1d2043\",\"dirty\":false,\"shared\":false}},\"nodeAliasses\":\"\\u5904\\u7f5a\\u51b3\\u5b9a\",\"nodeConstrainedPath\":\"A3\",\"nodeCountersign\":0,\"nodeCountersignIndex\":0.0,\"nodeCountersignType\":-1,\"nodeName\":\"\\u5904\\u7f5a\\u51b3\\u5b9a\",\"nodeNumber\":\"1\",\"nodeOutState\":0,\"nodeType\":4,\"processConfigID\":112,\"@metadata\":{\"objectID\":\"fc919533-c4eb-404e-9822-8e831a0c9ca0\",\"dirty\":false,\"shared\":false,\"rootVersionContextID\":\"2064.9e0bdec5-c5b5-41d5-845b-dcf8a3b248e3\",\"className\":\"BPMNodeInfo\"}},\"2\":{\"assignmentState\":1,\"boInfo\":{ \"selected\": [], \"items\": [], \"@metadata\":{\"objectID\":\"17eb9634-b3d5-4133-ad16-8373d0d93cf2\",\"dirty\":false,\"shared\":false}},\"formDefineUUID\":\"FORM201405231505494118\",\"isFreeAppreciation\":0,\"milepostNode\":0,\"nextNumbers\":{ \"selected\": [], \"items\": [\"1\"], \"@metadata\":{\"objectID\":\"b1cbeb9b-196a-4aa9-a512-73f483d50aa1\",\"dirty\":false,\"shared\":false}},\"nodeAliasses\":\"\\u53d7\\u7406\\u767b\\u8bb0\",\"nodeConstrainedPath\":\"A2\",\"nodeCountersign\":0,\"nodeCountersignIndex\":0.0,\"nodeCountersignType\":-1,\"nodeName\":\"\\u53d7\\u7406\\u767b\\u8bb0\",\"nodeNumber\":\"2\",\"nodeOutState\":0,\"nodeType\":4,\"processConfigID\":113,\"@metadata\":{\"objectID\":\"01e57079-da9c-426b-911d-e9bd77d1f9ab\",\"dirty\":false,\"shared\":false,\"rootVersionContextID\":\"2064.9e0bdec5-c5b5-41d5-845b-dcf8a3b248e3\",\"className\":\"BPMNodeInfo\"}},\"3\":{\"assignmentState\":0,\"boInfo\":{ \"selected\": [], \"items\": [], \"@metadata\":{\"objectID\":\"8d5c1c0f-5661-455d-9a01-94d33e831912\",\"dirty\":false,\"shared\":false}},\"isFreeAppreciation\":0,\"milepostNode\":0,\"nextNumbers\":{ \"selected\": [], \"items\": [\"2\"], \"@metadata\":{\"objectID\":\"fcf373ad-a983-48aa-9c2b-ecb86e81549c\",\"dirty\":false,\"shared\":false}},\"nodeAliasses\":\"\\u5f00\\u59cb\",\"nodeConstrainedPath\":\"A1\",\"nodeCountersign\":0,\"nodeCountersignIndex\":0.0,\"nodeCountersignType\":-1,\"nodeName\":\"\\u5f00\\u59cb\",\"nodeNumber\":\"3\",\"nodeOutState\":0,\"nodeType\":0,\"processConfigID\":115,\"@metadata\":{\"objectID\":\"c464bd06-f0ff-4f0a-9d37-f57b502e417f\",\"dirty\":false,\"shared\":false,\"rootVersionContextID\":\"2064.9e0bdec5-c5b5-41d5-845b-dcf8a3b248e3\",\"className\":\"BPMNodeInfo\"}},\"4\":{\"assignmentState\":0,\"boInfo\":{ \"selected\": [], \"items\": [], \"@metadata\":{\"objectID\":\"a7217fa1-3e90-420c-9055-4b746451f41e\",\"dirty\":false,\"shared\":false}},\"isFreeAppreciation\":0,\"milepostNode\":0,\"nodeAliasses\":\"\\u7ed3\\u675f\",\"nodeConstrainedPath\":\"A4\",\"nodeCountersign\":0,\"nodeCountersignIndex\":0.0,\"nodeCountersignType\":-1,\"nodeName\":\"\\u7ed3\\u675f\",\"nodeNumber\":\"4\",\"nodeOutState\":0,\"nodeType\":5,\"processConfigID\":114,\"@metadata\":{\"objectID\":\"4cb41bf8-8d27-433e-8db6-629d593e09d3\",\"dirty\":false,\"shared\":false,\"rootVersionContextID\":\"2064.9e0bdec5-c5b5-41d5-845b-dcf8a3b248e3\",\"className\":\"BPMNodeInfo\"}}},\"instanceVersion\":1,\"startDepartmentIds\":\"10004,10005,10148,10006,10013,10014,10007,10260,\",\"allGrantGroup\":{ \"selected\": [], \"items\": [\"6c5aa45e58154ce2ad513f693adc24f8\",\"c5cc62ade8b64fb6808ef7171dc7b770\"], \"@metadata\":{\"objectID\":\"8780142a-ecbc-4be6-90a2-76ae34369426\",\"dirty\":false,\"shared\":false}},\"bpmNumber\":\"\",\"createTime\":\"2015-03-09T03:14:58Z\",\"creator\":\"\\u6797\\u4e39\",\"powerName\":\"jal\\u5904\\u7f5a3\",\"firstNode\":\"3\",\"version\":\"1\",\"transactionId\":\"xq0008-B-001-004\",\"startDpmuuid\":\"5A03959E994C4FAFAC9559657B505425,F2EDA69CAE9F4EAF8D1B35B23FDECAEE,B5999FDE256248AEB4D5F2E8ED179CD9,151F9E70839648C98938C630D443FABF,EA29C48DC2DB4D2B9DA0A4BB1CC1D6D7,EBFF0B62203B4CA98C555116C32241A8,428E9428264941EDB08EB8484499F3E8,null,\",\"departmentName\":\"jal\\u586b\\u62a5\\u90e8\\u95e8\",\"powerType\":\"B\"}";
		Map<String, ? extends Object> map = json2Map(json);
		for(String key : map.keySet())
			System.out.println(key+"------>"+String.valueOf(map.get(key)));
//		System.out.println(getJsonObject(json, "1"));
		System.out.println("------------------------------------bpmNodesInfo---------------------------------------------------");
		String bpmNodesInfo = String.valueOf(map.get("bpmNodesInfo"));
		map.clear();
		map = json2Map(bpmNodesInfo);
		for(String key : map.keySet())
			System.out.println(key+"------>"+String.valueOf(map.get(key)));
	}*/

	public static void main(String[] args) {
		System.out.println("data".split("-"));
	}
	
	/**
	 * 将Map转换为Json字符串
	 * 
	 * @author chenjie
	 * @date 2015-1-23 下午04:25:46
	 * @param map
	 * @return String
	 */
	public static String map2Json(Map<String, ? extends Object> map) {
		if (null == map)
			return null;
		JSONObject jsonObject = JSONObject.fromObject(map);
		return jsonObject.toString();
	}
	
	/**
	 * 将对象转换为Json字符串
	 * 
	 * @author chenjie
	 * @date 2015-1-23 下午04:11:46
	 * @param object
	 * @return String
	 */
	public static String object2Json(Object object) {
		if (null == object)
			return null;
		JSONObject json = JSONObject.fromObject(object);
		return json.toString();
	}

}
