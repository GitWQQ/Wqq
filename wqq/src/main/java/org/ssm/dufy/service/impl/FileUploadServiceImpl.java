package org.ssm.dufy.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.ssm.dufy.dao.ShiroDemoDao;
import org.ssm.dufy.entity.UserInfo;
import org.ssm.dufy.service.FileUploadService;
import org.ssm.dufy.util.MathUtil;
import org.ssm.dufy.util.ReadExcel;
import org.ssm.dufy.util.pageHelp.DataGridResult;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Data;

@Service
public class FileUploadServiceImpl implements FileUploadService{

	@Autowired
	private ShiroDemoDao shiroDemoDao;
	
	@Override
	public boolean batchImport(String name, MultipartFile file) {
		boolean b=false;
		Map<String,Object> paramMap=new HashMap<>();
		//��������Excel
		ReadExcel readExcel=new ReadExcel();
		//����Excel����ȡ�ͻ��˼���
		List<UserInfo> userInfosList=readExcel.getExcelInfo(name,file);
		if(userInfosList !=null){
			b=true;
		}
		//��������û���Ϣ
		for(UserInfo userInfo:userInfosList){
			paramMap.put("name",userInfo.getName());
			paramMap.put("username",userInfo.getUsername());
			paramMap.put("password",userInfo.getPassword());
			paramMap.put("email",userInfo.getEmail());
			paramMap.put("yh_id",MathUtil.getId());
			shiroDemoDao.addNewUserInfo(paramMap);
		}
		return b;
	}
	
	public List batchImport2(String name ,MultipartFile file){
		//��������Excel
		ReadExcel readExcel=new ReadExcel();
		List<UserInfo> userInfos=readExcel.getExcelInfo(name,file);
		return userInfos;
	}
	
	@Override
	public List<Map<String,Object>> batchImport3(String name, MultipartFile file, String titles) {
		ReadExcel readExcel=new ReadExcel();
		List<Map<String,Object>> result=readExcel.getExcelInfo3(name,file, titles);
		return  result;
	}

	@Override
	public DataGridResult getAllRecord(Map<String,Object> paramMap) {
		int page=(int)paramMap.get("page"); 
		int rows=(int)paramMap.get("rows");
		PageHelper.startPage(page,rows);
		List list=shiroDemoDao.queryAllInfo();
		//����һ�����ض���
		DataGridResult dataGridResult=new DataGridResult();
		dataGridResult.setRows(list);
		//��ȡ��¼������
		PageInfo pageInfo=new PageInfo<>(list);
		dataGridResult.setTotal(pageInfo.getTotal());
		return dataGridResult;
	}

	@Override
	public int addRecordData(Map<String, Object> paramMap) {
		Map<String,Object> map=new HashMap<>();
		System.out.println("���ȣ�"+paramMap.size());
		return  shiroDemoDao.addNewUserInfo(paramMap);
	}

	@Override
	public List getAllData() {
		List result=shiroDemoDao.getAllData();
		return result;
	}

	
}
