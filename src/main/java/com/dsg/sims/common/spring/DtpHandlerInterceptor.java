package com.dsg.sims.common.spring;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dsg.sims.common.Constants;
import com.dsg.sims.common.model.ResponseMessage;
import com.dsg.sims.common.utils.JsonUtils;

/**
 * DTP 拦截处理类
 * author JieChen
 * createTime 3/15/16 1:27 PM
 */
public class DtpHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*Map<String,Object> map = new HashMap<>();
        map.putAll(modelAndView.getModel());
        ResponseMessage message = new ResponseMessage(Constants.STATE_SUCCESS_200, map);*/
        if(null == modelAndView)
            return;
        Map<String,Object> map = new HashMap<>();
        Map<String, Object> modelMap = modelAndView.getModel();
        for(String key : modelMap.keySet()){
            if(StringUtils.startsWith(key,"org.springframework.validation.BindingResult"))
                continue;
            map.put(key,modelMap.get(key));
        }
        ResponseMessage message = new ResponseMessage(Constants.STATE_SUCCESS_200,map);
        //把所有返回都当作ResponseBody
        modelAndView.clear();
        response.setHeader(Constants.HEADER_CONTENT_TYPE_KEY, Constants.HEADER_CONTENT_TYPE_VALUE);
        response.setCharacterEncoding(Constants.HEADER_CHARACTER_ENCODING);
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
//            String jecksonData = JsonUtils.object2Json(message);
            String jecksonData2 = JsonUtils.object2Json(message);
//            System.out.println(jecksonData);
            System.out.println(jecksonData2);
            writer.write(jecksonData2);
            writer.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
