package com.portal.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtils {

    /**
     * 计算当前时间加上指定月份的时间
     *
     * @param month
     * @return
     */
    public static Date getNewDateByAddMonth(double month) {
        Date newDate = null;
        try {
            Date date = new Date();
            int monthInt = (int) month;
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthInt);
            newDate = cal.getTime();
        } catch (RuntimeException e) {
            throw e;
        }
        return newDate;
    }

    /**
     * 计算当前时间加上指定天数的时间
     *
     * @param day
     * @return
     */
    public static String getNewDateByAddDay(double day) {
        String newDate = null;
        try {
            Date date = new Date();
            int dayInt = (int) day;
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE,dayInt);
            newDate = getDateFormatStr(cal.getTime(),"yyyy-MM-dd HH:mm:ss");
        } catch (RuntimeException e) {
            throw e;
        }
        return newDate;
    }
    /**
     * 计算指定时间加上指定天数的时间
     *
     * @param day
     * @return
     */
    public static String getNewDateByAddDay(String dateStr,double day) throws ParseException {
        String newDate = null;
        try {
            Date date = getDate(dateStr);
            int dayInt = (int) day;
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE,dayInt);
            newDate = getDateFormatStr(cal.getTime(),"yyyy-MM-dd HH:mm:ss");
        } catch (Exception e) {
            throw e;
        }
        return newDate;
    }

    /**
     * 计算指定时间加上指定天数的时间
     *
     * @param day
     * @return
     */
    public static String getNewDateByAddDay(String dateStr,double day,String dateformat) throws ParseException {
        String newDate = null;
        try {
            Date date = getDate(dateStr);
            int dayInt = (int) day;
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE,dayInt);
            newDate = getDateFormatStr(cal.getTime(),dateformat);
        } catch (Exception e) {
            throw e;
        }
        return newDate;
    }

    /**
     * 获取时间对象
     *
     * @param dateStr
     *            时间字符串 yyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date getDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateStr);
    }

    public static String getDateFormatStr(Date date, String formatStr) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        return sdf.format(date);
    }

    public static Date getDateFormat(String dateStr,String formatStr) throws ParseException {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        date = sdf.parse(dateStr);
        return date;
    }

    public static String getCurrentTimeMillis(){
        long timeMill = System.currentTimeMillis();
        String time = null;
        time = Long.toString(timeMill);
        return time;
    }

    /**
     * 获取当前日期的第一天或最后一天
     *
     * @param islast true 最后一天 false 第一天
     * @param date
     * @param format
     * @return
     */
    public static String getFirstOrLastDateByDate(boolean islast, Date date, String format) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, 0);
        if (islast) {
            cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 1);
            cal.set(Calendar.DATE, 0);
        } else {
            cal.set(Calendar.DATE, 1);
        }
        return getDateFormatStr(cal.getTime(), format);
    }

    public static Date getFirstOrLastDateByStr(boolean islast){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 0);
        if (islast) {
            cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + 1);
            cal.set(Calendar.DATE, 0);
            cal.set(Calendar.HOUR_OF_DAY,23);
            cal.set(Calendar.MINUTE,59);
            cal.set(Calendar.SECOND,59);
        } else {
            cal.set(Calendar.DATE, 1);
            cal.set(Calendar.HOUR_OF_DAY,0);
            cal.set(Calendar.MINUTE,0);
            cal.set(Calendar.SECOND,0);
        }
        return cal.getTime();
    }
    public static Map getFirstAndLastDate(Date date){
        Map map = new HashMap();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);// 设定当前时间为每月一号
        calendar.roll(Calendar.DAY_OF_MONTH, -1);
        map.put("JSSJ",calendar.getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);// 设定当前时间为每月一号
        cal.roll(cal.DAY_OF_MONTH, 0);
        map.put("KSSJ",cal.getTime());

//        cal.set(Calendar.DATE, 1);
//        cal.set(Calendar.HOUR_OF_DAY,0);
//        cal.set(Calendar.MINUTE,0);
//        cal.set(Calendar.SECOND,0);
//        map.put("KSSJ",cal.getTime());
        return map;
    }

    public static Date getBeforeOrAfterDay(String dateStr,Integer addDay) throws ParseException {
        Date date = getDateFormat(dateStr+" 00:00:00","yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day=c.get(Calendar.DATE);
        if(addDay>0){
            c.set(Calendar.DATE,day+addDay);
            c.set(Calendar.HOUR_OF_DAY,0);
            c.set(Calendar.MINUTE,0);
            c.set(Calendar.SECOND,0);
        }else{
            c.set(Calendar.DATE,day+addDay);
            c.set(Calendar.HOUR_OF_DAY,23);
            c.set(Calendar.MINUTE,59);
            c.set(Calendar.SECOND,59);
        }
        return c.getTime();
    }

    public static int getRiQiChaDays(Date date1, Date date2) {
        int dayInt = 0;
        long date1Time = date1.getTime();
        long date2Time = date2.getTime();
        if (date2Time > date1Time) {
            dayInt = (int) ((date2Time - date1Time) / 1000 / 60 / 60 );
        }
        return dayInt;
    }
    /***
     *
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateByPattern(Date date,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }
    /***
     * convert Date to cron ,eg.  "0 07 10 15 1 ? 2016"
     * @param date  : 时间点
     * @return
     */
    public static String getCron(Date  date){
        String dateFormat="ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }

    /**
     * s1大于s2？
     * @param s1
     * @param s2
     * @param formatStr yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static boolean compareTo(String s1, String s2, String formatStr){
        boolean bool = false;
        java.text.DateFormat df=new SimpleDateFormat(formatStr);
        Calendar c1= Calendar.getInstance();
        Calendar c2= Calendar.getInstance();
        try{
            c1.setTime(df.parse(s1));
            c2.setTime(df.parse(s2));
        }catch(ParseException e){
//			System.err.println("格式不正确");
        }
        int result=c1.compareTo(c2);
        if(result==0){
//			System.out.println("c1相等c2");
        }else if(result<0){
//			System.out.println("c1小于c2");
        }else{
//			System.out.println("c1大于c2");
            bool = true;
        }
        return bool;
    }

    public static Date addHours(Date date, int amount) {
        return add(date, 11, amount);
    }
    public static Date addMinutes(Date date, int amount) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, amount);

        return c.getTime();
    }
    public static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        } else {
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(calendarField, amount);
            return c.getTime();
        }
    }

    /**
     * 判断当前日期是周几
     *
     * @param date 需要判断的时间
     * @return
     * @throws Exception
     */
    public static String getDayForWeek(Date date) throws Exception {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day < 0) {
            day = 0;
        }
        return weekDays[day];
    }

    public static void main(String[] args) {
    }
}
