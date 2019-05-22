package org.ssm.dufy.api;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	
	public static void main(String[] arg){
		createFileDir("D://FileDemoDir");
	}
	//创建一个文件目录（文件夹）
	public static void createFileDir(String fileDirName){
		File file=new File(fileDirName);
		if(!file.exists()){
			file.mkdirs();
		}
		
		//创建一个nextFile目录（多级目录）
		File nextFile=new File(file,"fileChild");
		if(!nextFile.exists()){
			//mkdirs()可以创建多级文件夹，而mkdir()只能创建一级文件夹
			nextFile.mkdirs();
		}
		System.out.println("nextFile.getParent()为："+nextFile.getParent());
		if(nextFile.isDirectory()){
			File newFile=new File(nextFile,"file.txt");
			if(!newFile.exists()){
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("文件名为："+newFile.getName());
				System.out.println("文件的绝对路径是："+newFile.getAbsolutePath());
			}
			//一次性创建多个文本文件并为他们赋文件名
			for(int i=1;i<5;i++){
				File listFile=new File(nextFile,"file"+i+".txt");
				if(!listFile.exists()){
					try {
						listFile.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			//将nextFile路径下的文件名输出
			String [] list=nextFile.list();
			System.out.println("nextFile文件目录下的所有文件：");
			for (int i = 0; i < list.length; i++) {
				System.err.println(list[i]);
			}
		}
	}
	
	
}
