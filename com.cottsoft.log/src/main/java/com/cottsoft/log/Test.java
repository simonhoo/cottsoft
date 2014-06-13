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

package com.cottsoft.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description：<br> 
 * 
 * @author  Simon DJ Hu(Ask@China-Loong.com)
 * @date    2014年6月13日
 * @version v1.0
 */
public class Test {
	private Logger logger = LoggerFactory.getLogger(Test.class);   
	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
	
	public void test(){
		logger.debug("========================debug!");
		logger.info("========================info!");
		logger.warn("========================warn!");
		logger.error("========================error!");
	}

}


