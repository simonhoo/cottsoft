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

package com.cottsoft.demo.system;

/**
 * Description：<br> 
 * 获取系统信息
 * @author  Simon DJ Hu(Ask@China-Loong.com)
 * @date    2014年6月12日
 * @version v1.0
 */
public class SystemInfo {
	public static void main(String[] args) {
		printSysInfo();
	}

	public static void printSysInfo(){
		System.out.println("Java运行时环境版本 :"+System.getProperty("java.version")); 
        System.out.println("Java运行时环境供应商:"+System.getProperty("java.vendor")); 
        System.out.println("Java供应商的 URL:"+System.getProperty("java.vendor.url")); 
        System.out.println("Java安装目录 :"+System.getProperty("java.home")); 
        System.out.println("Java虚拟机规范版本 :"+System.getProperty("java.vm.specification.version")); 
        System.out.println("Java虚拟机规范供应商 :"+System.getProperty("java.vm.specification.vendor")); 
        System.out.println("Java虚拟机规范名称 :"+System.getProperty("java.vm.specification.name")); 
        System.out.println("Java虚拟机实现版本 :"+System.getProperty("java.vm.version")); 
        System.out.println("Java虚拟机实现供应商:"+System.getProperty("java.vm.vendor")); 
        System.out.println("Java虚拟机实现名称 :"+System.getProperty("java.vm.name")); 
        System.out.println("Java运行时环境规范版本 :"+System.getProperty("java.specification.version")); 
        System.out.println("Java运行时环境规范供应商:"+System.getProperty("java.specification.vendor")); 
        System.out.println("Java运行时环境规范名称:"+System.getProperty("java.specification.name")); 
        System.out.println("Java类格式版本号:"+System.getProperty("java.class.version")); 
        System.out.println("Java类路径:"+System.getProperty("java.class.path")); 
        System.out.println("加载库时搜索的路径列表:"+System.getProperty("java.library.path")); 
        System.out.println("默认的临时文件路径:"+System.getProperty("java.io.tmpdir")); 
        System.out.println("要使用的JIT编译器的名称:"+System.getProperty("java.compiler")); 
        System.out.println("一个或多个扩展目录的路径:"+System.getProperty("java.ext.dirs")); 
        System.out.println("操作系统的名称:"+System.getProperty("os.name")); 
        System.out.println("操作系统的架构:"+System.getProperty("os.arch")); 
        System.out.println("操作系统的版本:"+System.getProperty("os.version"));      
        System.out.println("文件分隔符:"+System.getProperty("file.separator"));    //文件分隔符（在 UNIX 系统中是“/”） 
        System.out.println("路径分隔符:"+System.getProperty("path.separator"));    //路径分隔符（在 UNIX 系统中是“:”） 
        System.out.println("行分隔符:"+System.getProperty("line.separator"));     //行分隔符（在 UNIX 系统中是“/n”） 
        System.out.println("用户的账户名称:"+System.getProperty("user.name")); 
        System.out.println("用户的主目录 :"+System.getProperty("user.home")); 
        System.out.println("用户的当前工作目录:"+System.getProperty("user.dir"));  
	}

}


