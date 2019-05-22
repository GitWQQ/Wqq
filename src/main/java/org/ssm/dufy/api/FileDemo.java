package org.ssm.dufy.api;

import java.io.File;
import java.io.IOException;

public class FileDemo {
	
	public static void main(String[] arg){
		createFileDir("D://FileDemoDir");
		
	}
	//����һ���ļ�Ŀ¼���ļ��У�
	public static void createFileDir(String fileDirName){
		File file=new File(fileDirName);
		if(!file.exists()){
			file.mkdirs();
		}
		
		//����һ��nextFileĿ¼���༶Ŀ¼��
		File nextFile=new File(file,"fileChild");
		if(!nextFile.exists()){
			//mkdirs()���Դ����༶�ļ��У���mkdir()ֻ�ܴ���һ���ļ���
			nextFile.mkdirs();
		}
		System.out.println("nextFile.getParent()Ϊ��"+nextFile.getParent());
		if(nextFile.isDirectory()){
			File newFile=new File(nextFile,"file.txt");
			if(!newFile.exists()){
				try {
					newFile.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("�ļ���Ϊ��"+newFile.getName());
				System.out.println("�ļ��ľ���·���ǣ�"+newFile.getAbsolutePath());
			}
			//һ���Դ�������ı��ļ���Ϊ���Ǹ��ļ���
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
			//��nextFile·���µ��ļ������
			String [] list=nextFile.list();
			System.out.println("nextFile�ļ�Ŀ¼�µ������ļ���");
			for (int i = 0; i < list.length; i++) {
				System.err.println(list[i]);
			}
		}
	}
	
	
}
