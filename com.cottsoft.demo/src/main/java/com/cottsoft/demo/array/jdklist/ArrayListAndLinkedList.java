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

package com.cottsoft.demo.array.jdklist;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

/**
 * Description：<br> 
 * 关于ArrayList和LinkedList遍历速度比较 Demo
 * @author  Simon DJ Hu(Ask@China-Loong.com)
 * @date    2014年6月11日
 * @version v1.0
 */
public class ArrayListAndLinkedList {

	private static Random random = new Random();   
	
	protected static String randomString() {   
        return Long.toString(random.nextLong(), 36);   
    } 
	
	/**
	 * 关于ArrayList和LinkedList遍历速度比较:
	 * 用for遍历,ArrayList比LinkedList快.多为4000倍.
	 * 用foreach遍历,LinkedList比ArrayList愉.约为2倍.
	 * 其中,用ArrayList的for遍历的速度最快,是LinkedList的2倍,ArrayList的foreach的3到4倍.
	 * @param args
	 */
	public static void main(String[] args) {
		 ArrayList<String> arraylist = new ArrayList<String>();   
         LinkedList<String> linkedlist = new LinkedList<String>();   
         for(int i=0;i<50000;i++){   
             String r = randomString();   
             arraylist.add(r);   
             linkedlist.add(r);   
         }   
         System.out.println("arraylist size "+arraylist.size());   
         System.out.println("linkedlist size "+linkedlist.size());   
         System.out.println("------");   
         long begin = System.currentTimeMillis();   
         for(int i=0;i<1000;i++){   
             for(int j=0;j<arraylist.size();j++){   
                 String s=arraylist.get(j); 
                 System.out.println(s);
             }   
         }   
         System.out.println("arraylist get(n) time "+(System.currentTimeMillis()-begin));   
            
         begin = System.currentTimeMillis();   
         for(int i=0;i<1000;i++){   
             for(String s:arraylist){ 
            	 System.out.println(s);
             }   
         }   
         System.out.println("arraylist foreach time "+(System.currentTimeMillis()-begin));   
            
         begin = System.currentTimeMillis();   
         for(int i=0;i<1;i++)   
         for(int j=0;j<linkedlist.size();j++){   
             String s=linkedlist.get(j);  
             System.out.println(s);
         }   
         System.out.println("linkedlist get(n) time "+(System.currentTimeMillis()-begin)*1000);   
            
         begin = System.currentTimeMillis();   
         for(int i=0;i<1000;i++)   
         for(String s:linkedlist){   
        	 System.out.println(s);
         }   
         System.out.println("linkedlist foreach time "+(System.currentTimeMillis()-begin));   

	}
	
}


