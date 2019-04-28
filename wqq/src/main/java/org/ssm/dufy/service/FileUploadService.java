package org.ssm.dufy.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.ssm.dufy.util.pageHelp.DataGridResult;

public interface FileUploadService {
	
	//批量导入数据库客户
	public boolean batchImport(String name,MultipartFile file);
	//获取Excel数据
	public List batchImport2(String name,MultipartFile file);
	//
	public List batchImport3(String name,MultipartFile file,String titles);

	//获取数据库里所有数据
	public DataGridResult getAllRecord(Map<String,Object> paramMap);
	//
	public int addRecordData(Map<String,Object> paramMap);
	//获取所有数据
	public List getAllData();

}
