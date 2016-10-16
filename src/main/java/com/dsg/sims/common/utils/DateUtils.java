package com.dsg.sims.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * author JieChen
 * createTime 11/19/15 4:58 PM
 */
public class DateUtils {

    /**
     * 时间格式
     */
    public static final String HH_MM_SS_S = "HH:mm:ss.S";

    /**
     * 时间格式
     */
    public static final String HH_MM_SS = "HH:mm:ss";


    /**
     * 时间格式
     */
    public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * 时间格式
     */
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    /**
     * 时间格式
     */
    public static final String YYYY_MM = "yyyy-MM";

    /**
     * 时间格式
     */
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    /**
     * 时间格式
     */
    public static final String YYYYMMDDHHMMSSS = "yyyyMMddHHmmssS";

    /**
     * 时间格式
     */
    public static final String YYYYNMMYDDR = "yyyy年MM月dd日";

    /**
     * 时间格式
     */
    public static final String YYYYMMDD_HHMMSSS = "yyyyMMdd-HHmmssS";

    /**
     * 时间格式
     */
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 凌晨时间点
     */
    public static final String DATE_START_TIME = " 00:00:00";

    /**
     * 最晚时间
     */
    public static final String DATE_END_TIME = " 23:59:59";

    private DateUtils() {

    }

    /**
     * 格式化时间
     *
     * @param strDate 字符串日期
     * @param format  转换格式
     * @return Timestamp
     */
    public static Date formatDate(final String strDate, final String format) throws ParseException {
        return new SimpleDateFormat(format).parse(strDate);
    }

    /**
     * 转换日期为字符串
     *
     * @param date   日期
     * @param format 格式
     * @return String
     */
    public static String formatDateToString(final Date date, final String format) {
        SimpleDateFormat SimpleDateFormat = new SimpleDateFormat(format);
        return SimpleDateFormat.format(date);
    }

    /**
     * 获取指定日期的Time Millis
     *
     * @param date 日期
     * @return long
     */
    public static long getDateTimeMillis(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.getTimeInMillis();
    }


}
