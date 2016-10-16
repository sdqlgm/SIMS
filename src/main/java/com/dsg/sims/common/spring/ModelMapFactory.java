package com.dsg.sims.common.spring;

import java.util.Map;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

/**
 * ModelMap工厂类
 * author JieChen
 * createTime 3/24/16 11:05 AM
 */
public class ModelMapFactory {

    private ModelMapFactory() {

    }

    /**
     * 构建ModelMap对象
     * @param key key
     * @param object 值
     * @return Model
     */
    public static Model buildModelMap(String key,Object object){
        Model model = new ExtendedModelMap();
        model.addAttribute(key,object);
        return model;
    }

    /**
     * 构建ModelMap对象
     * @param resultMap 结果集
     * @return Model
     */
    public static Model buildModelMap(Map<String,Object> resultMap){
        Model model = new ExtendedModelMap();
        for(String key : resultMap.keySet())
            model.addAttribute(key,resultMap.get(key));
        return model;
    }
}
