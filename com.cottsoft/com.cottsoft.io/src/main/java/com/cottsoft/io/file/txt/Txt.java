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
 * Author:	Simon.Hoo
 * Blog:   	http://www.cottsoft.com 
 * Email:	Info@cottsoft.com
 * 
 * You can @simonhoo  on Github.com, weibo.com, twitter, t.qq.com
 */

package com.cottsoft.io.file.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Description：<br> 
 * Txt文本操作
 * @author  Simon.Hoo(Info@cottsoft.com)
 * @date    Oct 31, 2014
 * @version v1.0.0
 */
public class Txt {
	/**  
     * @param filePath 文件路径  
     * @return 读出的txt的内容  
     */  
    public String getTextFromTxt(String filePath) throws Exception {   
           
        FileReader fr = new FileReader(filePath);   
        BufferedReader br = new BufferedReader(fr);   
        StringBuffer buff = new StringBuffer();   
        String temp = null;   
        while((temp = br.readLine()) != null){   
            buff.append(temp + "\r\n");   
        }   
        br.close();        
        return buff.toString();        
    }   
    
    
	/**
	 * 创建目录，当所传进来的参数值目录不存在时，则创建
	 * @param path
	 * @throws IOException
	 */
	public static void createFolder(String path) throws IOException {
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
	}
	
	
	/**
	 * 创建文件，当所传参数路径+文件名不存在时，则创建。
	 * @param path 路径
	 * @param fileName 文件名
	 * @throws IOException
	 */
	public static void createFile(String path,String fileName) throws IOException {
		File filePath = new File(path);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}
		File file = new File(path+File.separator+fileName);
		if(!file.exists()){
			file.createNewFile();
		}
	}
	
	/**
	 * 写文件
	 * @param path
	 * @param fileName
	 * @param content
	 * @param encode
	 * @throws IOException
	 */
	public static void writeFile(String path,String fileName,String content) throws IOException{
		createFile(path,fileName);
		FileWriter writer = null;		
		RandomAccessFile randomFile = null;		
		FileReader reader = null;
		String pathAndName = path+File.separator+fileName;
		reader = new FileReader(pathAndName);			
		if (reader.read() == -1) {
			writer = new FileWriter(pathAndName);
			writer.write(content);
		} else {
			randomFile = new RandomAccessFile(pathAndName, "rw");
			long fileLength = randomFile.length();
			randomFile.seek(fileLength);
			randomFile.write(("\n" + content).getBytes());
		}
		if (writer != null) {
			writer.close();
		}
		if (randomFile != null) {
			randomFile.close();
		}
		if(reader !=null){
			reader.close();
		}
	}
	
	public static void backupFile(String path){
		try {
			File file = new File(path);
			if (file.exists()) {
				File[] files = file.listFiles();
				
				SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmss");
				String _tmep = sf.format(new Date());
				
				for(File f : files){
					if(f.isFile()){
						String backuppath = path+ File.separator + "Backup";
						File bkfilePath = new File(backuppath);
						if (!bkfilePath.exists()) {
							bkfilePath.mkdirs();
						}
						f.renameTo(new File(backuppath+File.separator+f.getName()+"_"+_tmep));
					}
				}
			}
		} catch (Exception e) {

		}
	}
}


