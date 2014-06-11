/*
 * Copyright 2005-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Main Author:  Simon DJ Hu
 * Website:      http://www.China-Loong.com 
 * Email:        ask@China-Loong.com   or  simon.dj.hu@gmail.com
 * 
 * You can @simonhoo  on weibo.com, twitter, t.qq.com
 */

package com.cottsoft.common.datatime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description：<br> 
 * Date Time
 * @author  Simon DJ Hu(Ask@China-Loong.com)
 * @date    2014年6月11日
 * @version v1.0
 */
public class DateTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 验证日期格式是否有效
	 * @param stringDate 字符型日期
	 * @param partternDttmType 匹配的日期格式(如：\\d{4}\\d{2}\\d{2} 即yyyyMMdd, \\d{4}\\-d{2}\\-d{2} 即yyyy-MM-dd)
	 * @return 返回true/false
	 */
	public static boolean isValidDate(String stringDate,String partternDttmType) {
	     String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
	             + "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
	             + "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
	             + "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
	             + "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
	             + "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
	     if ((stringDate != null)) {
	         Pattern pattern = Pattern.compile(partternDttmType);
	         Matcher match = pattern.matcher(stringDate);
	         if (match.matches()) {
	             pattern = Pattern.compile(datePattern2);
	             match = pattern.matcher(stringDate);
	             return match.matches();
	         }
	         else {
	             return false;
	         }
	     }
	     return false;
	 }
	
	/**
	 * 计算所传进去的参数yyyy,mm,dd是一年当中第几个星期?
	 * @param yyyy int类型(年)
	 * @param mm int类型(月)
	 * @param dd int类型(日)
	 * @return int类型(第几个星期)
	 */
	public static int whichWeekInYear(int yyyy,int mm,int dd){
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, yyyy);
		cal.set(Calendar.MONTH, mm);
		cal.set(Calendar.DAY_OF_MONTH, dd);
		int weekno=cal.get(Calendar.WEEK_OF_YEAR);	
		return weekno;
	}
	

	/**
	 * 计算一年中的第几星期是几号?
	 * @param year int类型(年)
	 * @param weekOfYear int类型(一年中的第几个星期)
	 * @return dttm String类型(日期yyyy-MM-dd)
	 */
	public static String whichDayInYearMonth(int year,int weekOfYear){
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		String str = df.format(cal.getTime());
		
		return str;
	}
	
	/**
	 * 计算两个任意时间中间的间隔天数（这个比较常用）
	 * @param startday Calendar类型(起始时间)
	 * @param endday Calendar类型(结束时间)
	 * @return days int类型(天数)
	 */
	public int getIntervalDays(Calendar startday,Calendar endday){       
        if(startday.after(endday)){
            Calendar cal=startday;
            startday=endday;
            endday=cal;
        }    
        long sl=startday.getTimeInMillis();
        long el=endday.getTimeInMillis();
       
        long ei=el-sl;           
        return (int)(ei/(1000*60*60*24));
    }
	
	/**
	 * 计算两个任意时间中间的间隔天数
	 * @param startday Date类型(起始时间)
	 * @param endday Date类型(起始时间)
	 * @return days int类型(天数)
	 */
	public int getIntervalDays(Date startday,Date endday){        
        if(startday.after(endday)){
            Date cal=startday;
            startday=endday;
            endday=cal;
        }        
        long sl=startday.getTime();
        long el=endday.getTime();       
        long ei=el-sl;           
        return (int)(ei/(1000*60*60*24));
    }
	
	/**
	 * 改进精确计算相隔天数的方法
	 * @param startDttm Calendar类型(起始时间)
	 * @param endDttm Calendar类型(结束时间)
	 * @return days int类型(天数)
	 */
	public int getDaysBetween (Calendar startDttm, Calendar endDttm){
        if (startDttm.after(endDttm)){ 
            java.util.Calendar swap = startDttm;
            startDttm = endDttm;
            endDttm = swap;
        }
        int days = endDttm.get(Calendar.DAY_OF_YEAR) - startDttm.get(Calendar.DAY_OF_YEAR);
        int y2 = endDttm.get(Calendar.YEAR);
        if (startDttm.get(Calendar.YEAR) != y2){
            startDttm = (Calendar) startDttm.clone();
            do{
                days += startDttm.getActualMaximum(Calendar.DAY_OF_YEAR);//得到当年的实际天数
                startDttm.add(Calendar.YEAR, 1);
            } while (startDttm.get(Calendar.YEAR) != y2);
        }
        return days;
    }
	
	
	/**
	 * 返回当前时间的String类型
	 * @param dataFormt 格式化参数（如：yyyy-MM-dd、yyyy-MM-dd HH:mm:ss）
	 * @return 返回格式化后的字符串
	 */
	public static String getSystemDateTime(String dataFormt) {
		SimpleDateFormat sf = new SimpleDateFormat(dataFormt);
		Date sysNow = new Date();
		String nowDttm = sf.format(sysNow);
		return nowDttm;
	}

}


