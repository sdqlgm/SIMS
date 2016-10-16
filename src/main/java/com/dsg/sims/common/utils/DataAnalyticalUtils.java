package com.dsg.sims.common.utils;

import com.dsg.sims.common.Constants;
import org.apache.commons.lang.time.DateUtils;

import java.io.IOException;
import java.util.Date;

/**
 * 数据解析工具类
 * author JieChen
 * createTime 11/17/15 5:01 PM
 */
public final class DataAnalyticalUtils {

    private DataAnalyticalUtils() {

    }

    /**
     * 将字节数组以16进制字符串输出，每个字节之间以空格分隔
     *
     * @param bytes 二进制字节数组
     * @return String
     */
    public static String formatHexString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            builder.append(hex);
        }
        return builder.toString().trim();
    }

    /**
     * 将字节数组以10进制字符串输出
     */
    public static String formatDecString(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toString(b & 0xFF);
            builder.append(hex);
        }
        return builder.toString();
    }
    
    /**
     * 取源byte数组中一段转换为10进制字符串
     *
     * @param srcBytes 源数组
     * @param srcPos   源数组起始位置
     * @param length   长度
     * @return String
     */
    public static String formatDecString(byte[] srcBytes, int srcPos, int length) {
        byte[] bytes = copyBytes(srcBytes, srcPos, length);
        return formatDecString(bytes);
    }

    /**
     * 转换字节数组为整数
     *
     * @param bytes 字节数组
     * @return int
     */
    public static int formatInt(byte[] bytes) {
        int i = 0;
        for (byte b : bytes)
            i += b & 0xFF;
        return i;
    }

    /**
     * 解析信达时间戳
     *
     * @param bytes 字节数组
     * @return Date
     * @throws IOException
     */
    public static Date analyticalXDecoTime(byte[] bytes) throws IOException {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes)
            builder.append(byteToBit(b));
        String dateStr = builder.toString();
        int year = Integer.valueOf(dateStr.substring(0, 12), 2);
        int month = Integer.valueOf(dateStr.substring(12, 16), 2) - 1;
        int day = Integer.valueOf(dateStr.substring(16, 21), 2);
        int hours = Integer.valueOf(dateStr.substring(21, 26), 2);
        int minutes = Integer.valueOf(dateStr.substring(26, 32), 2);
        int seconds = Integer.valueOf(dateStr.substring(32, 38), 2);
        int milliseconds = Integer.valueOf(dateStr.substring(38, 40), 2) * 250;
        // 根据解析结果，利用org.apache.commons.lang3.time.DateUtils来构建Date类
        Date date = new Date();
        date = DateUtils.setMilliseconds(date, milliseconds);
        date = DateUtils.setSeconds(date, seconds);
        date = DateUtils.setMinutes(date, minutes);
        date = DateUtils.setHours(date, hours);
        date = DateUtils.setDays(date, day);
        date = DateUtils.setMonths(date, month);
        date = DateUtils.setYears(date, year);
        return date;
    }

    /**
     * Byte转Bit
     */
    public static String byteToBit(byte b) {
        return "" + (byte) ((b >> 7) & 0x1) +
                (byte) ((b >> 6) & 0x1) +
                (byte) ((b >> 5) & 0x1) +
                (byte) ((b >> 4) & 0x1) +
                (byte) ((b >> 3) & 0x1) +
                (byte) ((b >> 2) & 0x1) +
                (byte) ((b >> 1) & 0x1) +
                (byte) ((b >> 0) & 0x1);

    }

    /**
     * 复制字节数组
     *
     * @param length   复制的长度
     * @param srcBytes 源字节数组
     * @param srcPos   源起始位置
     * @return byte[]
     */
    public static byte[] copyBytes(byte[] srcBytes, int srcPos, int length) {
        byte[] tempBytes = new byte[length];
        System.arraycopy(srcBytes, srcPos, tempBytes, 0, length);
        return tempBytes;
    }

    /**
     * 取源byte数组中一段转换为16进制字符串
     *
     * @param srcBytes 源数组
     * @param srcPos   源数组起始位置
     * @param length   长度
     * @return String
     */
    public static String formartHexString(byte[] srcBytes, int srcPos, int length) {
        byte[] bytes = copyBytes(srcBytes, srcPos, length);
        return formatHexString(bytes);
    }

    /**
     * 取源byte数组中一段转换为整型
     *
     * @param srcBytes 源数组
     * @param srcPos   源数组起始位置
     * @param length   长度
     * @return int
     */
    public static int formartInt(byte[] srcBytes, int srcPos, int length) {
        byte[] bytes = copyBytes(srcBytes, srcPos, length);
        return formatInt(bytes);
    }

    /**
     * 取源byte数组中一段转换为16进制字符串
     *
     * @param srcBytes 源数组
     * @param srcPos   源数组起始位置
     * @return String
     */
    public static Date formartDate(byte[] srcBytes, int srcPos) throws IOException {
        byte[] bytes = copyBytes(srcBytes, srcPos, Constants.XDECO_TIME_BYTE_LENGTH);
        return analyticalXDecoTime(bytes);
    }

    /**
     * 把整型转换成16进制byte数组
     *
     * @param arg 整数
     * @return byte数组
     */
    public static byte[] toHexBytes(int arg) {
        String hexString = Integer.toHexString(arg);
        if (hexString.length() % 2 != 0)
            hexString = "0" + hexString;
        int hexLength = hexString.length();
        byte[] bytes;
        if (hexLength > 2) {
            bytes = new byte[hexLength / 2];
            int bytesIndex = 0;
            for (int i = 0; i <= hexLength / 2; i += 2) {
                bytes[bytesIndex] = hexStringToByte(hexString.substring(i, i + 2));
                bytesIndex++;
            }
        } else {
            bytes = new byte[1];
            bytes[0] = hexStringToByte(hexString);
        }
        return bytes;
    }

    /**
     * 转换16进制字符串为byte
     *
     * @param hexString 16进制字符串
     * @return byte
     */
    private static byte hexStringToByte(String hexString) {
        int a = Integer.parseInt(hexString, 16);
        return (byte) (a & 0xFF);
    }

}
