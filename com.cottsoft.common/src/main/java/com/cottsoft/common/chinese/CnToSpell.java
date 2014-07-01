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

package com.cottsoft.common.chinese;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


/**
 * Description：<br>
 * 汉字转化为全拼工具类
 * 
 * @author Simon DJ Hu(Ask@China-Loong.com)
 * @date 2013年6月5日
 * @version v1.0
 */
public class CnToSpell {
	
	/**
	 * 将汉字转换为全拼
	 * @param cnChar
	 * @return
	 */
    public static String getCnSpell(String cnChar) {

        char[] t1 = null;
        t1 = cnChar.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        StringBuffer t4 = new StringBuffer();
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches(
                        "[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4.append(t2[0]);
                } else{
                	t4.append(java.lang.Character.toString(t1[i]));
                }
                t4.append(" ");
            }
            return t4.toString();
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4.toString();
    }

    // 返回中文的首字母
    public static String getCnSpellFirstChar(String str) {
        String temp = "";
        String demo = "";
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        for(int i=0;i<convert.length();i++){//convert目前为小写首字母,下面是将小写首字母转化为大写
            if(convert.charAt(i)>='a' && convert.charAt(i)<='z'){
                temp=convert.substring(i,i+1).toUpperCase();
                demo += temp;
            }
        }
        return demo;
    }

    /**
     * 将字符串转移为ASCII码
     * @param cnStr
     * @return
     */
    public static String getCnASCII(String cnStr) {
        StringBuffer strBuf = new StringBuffer();
        byte[] bGBK = cnStr.getBytes();
        for (int i = 0; i < bGBK.length; i++) {
            strBuf.append(Integer.toHexString(bGBK[i] & 0xff));
        }
        return strBuf.toString();
    }

    public static void main(String[] args) {

        String cnStr = "中华人民共和国";
        System.out.println(getCnSpell(cnStr));
        System.out.println(getCnSpellFirstChar(cnStr));
    }

}
