package org.ssm.dufy.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.ssm.dufy.util.pageHelp.DataGridResult;

public interface FileUploadService {
	
	//�����������ݿ�ͻ�
	public boolean batchImport(String name,MultipartFile file);
	//��ȡExcel����
	public List batchImport2(String name,MultipartFile file);
	//
	public List batchImport3(String name,MultipartFile file,String titles);

	//��ȡ���ݿ�����������
	public DataGridResult getAllRecord(Map<String,Object> paramMap);
	//
	public int addRecordData(Map<String,Object> paramMap);
	//��ȡ��������
	public List getAllData();

}
