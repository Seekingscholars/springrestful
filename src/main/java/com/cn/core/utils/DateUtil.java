package com.cn.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;  
  
public class DateUtil {  
    /** 
     * 获取SimpleDateFormat 
     * @param parttern 日期格式 
     * @return SimpleDateFormat对象 
     * @throws RuntimeException 异常：非法日期格式 
     */  
    private static SimpleDateFormat getDateFormat(String parttern) throws RuntimeException {  
        return new SimpleDateFormat(parttern);  
    }  
  
    /** 
     * 获取日期中的某数值。如获取月份 
     * @param date 日期 
     * @param dateType 日期格式 
     * @return 数值 
     */  
    private static int getInteger(Date date, int dateType) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTime(date);  
        return calendar.get(dateType);  
    }  
      
      
    /** 
     * 增加日期中某类型的某数值。如增加日期 
     * @param date 日期 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期 
     */  
    private static Date addInteger(Date date, int dateType, int amount) {  
        Date myDate = null;  
        if (date != null) {  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);
            calendar.add(dateType, amount);  
            myDate = calendar.getTime();  
        }  
        return myDate;  
    }
    
    /** 
     * 增加日期中某类型的某数值。如增加日期 
     * @param date 日期 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期 
     */  
    public static String longXdate(long millis, int dateType, int amount,String parttern) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.setTimeInMillis(millis);
        calendar.add(dateType, amount);  
        Date myDate = calendar.getTime();
        return getDateFormat(parttern).format(myDate);
    }
  
    
  
    /** 
     * 将日期字符串转化为日期。失败返回null。 
     * @param date 日期字符串 
     * @param parttern 日期格式 
     * @return 日期 
     */  
    public static Date StringToDate(String date, String parttern) {  
        Date myDate = null;  
        if (date != null) {  
            try {  
                myDate = getDateFormat(parttern).parse(date);  
            } catch (Exception e) {  
            }  
        }  
        return myDate;  
    }  
  
  
    /** 
     * 将日期转化为日期字符串。失败返回null。 
     * @param date 日期 
     * @param parttern 日期格式 
     * @return 日期字符串 
     */  
    public static String DateToString(Date date, String parttern) {  
        String dateString = null;  
        if (date != null) {  
            try {  
                dateString = getDateFormat(parttern).format(date);  
            } catch (Exception e) {  
            }  
        }  
        return dateString;  
    }  
    
    /** 
     * 将毫秒数转化为日期字符串。失败返回null。 
     * @param time 毫秒数
     * @param parttern 日期格式 
     * @return 日期字符串 
     */  
    public static String longtimeToString(long time, String parttern) {  
        String dateString = null;  
        try {  
            dateString = getDateFormat(parttern).format(time);  
        } catch (Exception e) {  
        } 
        return dateString;  
    } 
      
    /** 
     * 增加日期的年份。失败返回null。 
     * @param date 日期 
     * @param yearAmount 增加数量。可为负数 
     * @return 增加年份后的日期 
     */  
    public static Date addYear(Date date, int yearAmount) {  
        return addInteger(date, Calendar.YEAR, yearAmount);  
    }  
      
    /** 
     * 增加日期的月份。失败返回null。 
     * @param date 日期 
     * @param yearAmount 增加数量。可为负数 
     * @return 增加月份后的日期 
     */  
    public static Date addMonth(Date date, int yearAmount) {  
        return addInteger(date, Calendar.MONTH, yearAmount);  
    }  
      
  
    /** 
     * 增加日期的天数。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加天数后的日期 
     */  
    public static Date addDay(Date date, int dayAmount) {  
        return addInteger(date, Calendar.DATE, dayAmount);  
    }  
      
  
    /** 
     * 增加日期的小时。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加小时后的日期 
     */  
    public static Date addHour(Date date, int hourAmount) {  
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);  
    }  
      
  
    /** 
     * 增加日期的分钟。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加分钟后的日期 
     */  
    public static Date addMinute(Date date, int hourAmount) {  
        return addInteger(date, Calendar.MINUTE, hourAmount);  
    }  
      
  
    /** 
     * 增加日期的秒钟。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加秒钟后的日期 
     */  
    public static Date addSecond(Date date, int hourAmount) {  
        return addInteger(date, Calendar.SECOND, hourAmount);  
    }  
  
  
    /** 
     * 获取日期的年份。失败返回0。 
     * @param date 日期 
     * @return 年份 
     */  
    public static int getYear(Date date) {  
        return getInteger(date, Calendar.YEAR);  
    }  
  
  
    /** 
     * 获取日期的月份。失败返回0。 
     * @param date 日期 
     * @return 月份 
     */  
    public static int getMonth(Date date) {  
        return getInteger(date, Calendar.MONTH);  
    }  
  
  
    /** 
     * 获取日期的天数。失败返回0。 
     * @param date 日期 
     * @return 天 
     */  
    public static int getDay(Date date) {  
        return getInteger(date, Calendar.DATE);  
    }  
      
  
    /** 
     * 获取日期的小时。失败返回0。 
     * @param date 日期 
     * @return 小时 
     */  
    public static int getHour(Date date) {  
        return getInteger(date, Calendar.HOUR_OF_DAY);  
    }  
      
  
    /** 
     * 获取日期的分钟。失败返回0。 
     * @param date 日期 
     * @return 分钟 
     */  
    public static int getMinute(Date date) {  
        return getInteger(date, Calendar.MINUTE);  
    }  
      
  
    /** 
     * 获取日期的秒钟。失败返回0。 
     * @param date 日期 
     * @return 秒钟 
     */  
    public static int getSecond(Date date) {  
        return getInteger(date, Calendar.SECOND);  
    }  
  
    /** 
     * 获取日期。默认yyyy-MM-dd格式。失败返回null。 
     * @param date 日期 
     * @return 日期 
     */  
    public static String getDate(Date date,String parttern) {  
        return DateToString(date, parttern);  
    }
    public static Date getCurrentTime(){
    	return new Date();
    }
    
    public static long getCurrentTimestamp(){
    	return System.currentTimeMillis();
    }
    
    public static String getCurrentHour(){
    	return DateUtil.getDate(getCurrentTime(),"HH");
    }
    
    public static String getCurrentDate(){
    	return DateUtil.getDate(getCurrentTime(),"yyyyMMdd");
    }
    
    public static String getCurrentDMinute(){
    	return DateUtil.getDate(getCurrentTime(),DateStyle.YYYYMMDDHHMM.getValue());
    }
    
    public static String getPreDMinute(int m){
    	return DateUtil.getDate(addMinute(getCurrentTime(),m),DateStyle.YYYYMMDDHHMM.getValue());
    }
    
    public static String getNextDate(){
    	return getDate(addDay(getCurrentTime(),1),"yyyyMMdd");
    }
    
    public static String getPreDate(){
    	return getDate(addDay(getCurrentTime(),-1),"yyyyMMdd");
    }
    
    
    public static String getPreDMinuteSegment(int m){
    	String cminute = getPreDMinute(m);
    	cminute = cminute.substring(0,cminute.length()-1) + "0";
    	return cminute;
    }
    
    public static long getCurrentTimestamp(String date,String parttern){
    	SimpleDateFormat format = getDateFormat(parttern);
    	long l = 0l;
    	try {
			Date dt = format.parse(date);
			l = dt.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	return l;
    }
    public static void main(String[] args){
    	String parttern = "yyyy-MM-dd";//转换时间格式
    	String partternx = DateStyle.YYYY_MM_DD_HH_MM_SS.getValue();
    	/**/
    	/*System.out.println(getPreDMinute(-10));
    	String cminute = getPreDMinute(-10);
    	cminute = cminute.substring(0,cminute.length()-1) + "0";
    	System.out.println(cminute);
    	
    	System.out.println(getPreDMinuteSegment(-10));
    	System.out.println(getPreDMinuteSegment(0));*/
    	
    	System.out.println(DateToString(addMonth(new Date(),1),parttern));
    	System.out.println(DateToString(addMonth(new Date(),0),parttern));
    	System.out.println(DateToString(addMonth(new Date(),-1),parttern));
    	long source = 1473327792000l; 
    	long ldate = new Date().getTime();
    	try {
			System.out.println(source+" - "+getDateFormat(parttern).format(source));
			System.out.println(source+" - "+longXdate(source,Calendar.MONTH,-1,parttern));
			System.out.println(source+" - "+longXdate(source,Calendar.DATE,-1,parttern));
		}catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//    	System.out.println(Math.random());
    }
}  
