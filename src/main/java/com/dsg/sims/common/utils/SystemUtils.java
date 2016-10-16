package com.dsg.sims.common.utils;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;

import com.dsg.sims.common.Constants;

/**
 * 系统工具类
 * author Zhang Shunjiang
 * createTime 2015-11-19 下午2:36:47
 */
public final class SystemUtils {

    private SystemUtils() {

    }

    /**
     * 队列比较
     *
     * @param <T>
     * @param a
     * @param b
     * @return boolean
     * @throws Exception
     */
    public static <T> boolean compare(List<T> a, List<T> b) throws Exception {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;
        if (a.size() == 0 && b.size() == 0)
            return true;
        if (a.size() != b.size())
            return false;
        Method method = a.get(0).getClass().getMethod("equals", Object.class);
        if (method == null)
            return false;
        for (int i = 0; i < a.size(); i++) {
            Object object = method.invoke(a.get(i), b.get(i));
            boolean result = Boolean.parseBoolean(String.valueOf(object));
            if (result) {
                continue;
            }
            return false;
        }
        return true;
    }




    /**
     * 获取字符串中字符出现次数
     *
     * @param str 字符串
     * @param con 字符
     * @return int
     */
    public static int numberOfStr(String str, String con) {
        str = " " + str;
        if (str.endsWith(con)) {
            return str.split(con).length;
        } else {
            return str.split(con).length - 1;
        }
    }

    /**
     * 截取小数位数，四舍五入
     * @param d 要截取的数据
     * @param round 保留位数
     * @return double
     */
    public static double roundMeth(double d, int round) {
        BigDecimal bigDecimal = new BigDecimal(d);
        return bigDecimal.setScale(round, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 根据行政区划获取前几位<br>
     *     650100 --> 6501
     * @param regionId 行政区划
     * @return String
     */
    public static String getSuperRegionId(String regionId){
        if(StringUtils.isBlank(regionId)){
            return Constants.REGION_ROOT_ID;
        }
        char[] chars = regionId.toCharArray();
        int endSub = chars.length-1;
        for (int i = endSub; i >= 0; i--) {
            if('0' != chars[i]){
                break;
            }
            if('0' == chars[i]){
                endSub --;
            }
        }
        endSub ++;
        return new String(chars,0,endSub);
    }
    public static void main(String[] args) {
        /*double pie = 3.1415926;
        System.out.println(roundMeth(pie,4));
        char a = '0';
        System.out.println(0 == a);
        String regionId = "650100";
        System.out.println(getSuperRegionId(regionId));
//        char[] chars = regionId.toCharArray();
        System.out.println(SystemUtils.createUuid().length());*/
//        System.out.println(getResourcePath());
    }



    /**
     * 创建UUID
     * @return String
     */
    public static String createUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }


}
