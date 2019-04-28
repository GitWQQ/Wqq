package org.ssm.dufy.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.tagext.PageData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.ssm.dufy.entity.UserInfo;
import org.ssm.dufy.service.FileUploadService;
import org.ssm.dufy.util.ExcelUtil;
import org.ssm.dufy.util.pageHelp.DataGridResult;

@Controller
public class FileUploadController{
	private static Logger logger=LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	private FileUploadService fileUploadService; 
	
	@RequestMapping(value="/batchimport.shtml",method=RequestMethod.POST)
	public String batchImport(@RequestParam(value="filename")MultipartFile file,
			HttpServletRequest request,HttpServletResponse response){
		logger.info("FileUploadController .. batchImport() start");
		//判断文件是否为空
		if(file==null){
			return null;
		}
		//获取文件名
		String name=file.getOriginalFilename();
		//进一步判断文件是否为空(即判断其大小是否为0或其名称是否为null)
		long size=file.getSize();
		if(name==null || "".equals(name) && size==0){
			return null;
		}
		//批量导入，参数：文件名，文件
		boolean b=fileUploadService.batchImport(name, file);
		if(b){
			String Msg="批量导入成功";
			request.getSession().setAttribute("msg", Msg);
		}else{
			String Msg="批量导入失败";
			request.getSession().setAttribute("msg",Msg);
		}
		return "Excel";
	}
	
	@RequestMapping(value="/batchimport2.shtml",method=RequestMethod.POST)
	public String batchImport2(@RequestParam(value="filename")MultipartFile file,
			HttpServletRequest request,HttpServletResponse response,Model model){
		
		//判断文件是否为空
		if(file==null){
			model.addAttribute("msg","文件不能为空");
		}else{
			//获取文件名
			String name=file.getOriginalFilename();
			long size=file.getSize();
			if(name==null || "".equals(name) && size==0){
				model.addAttribute("msg","文件不能为空");
			}
			List resultList=fileUploadService.batchImport2(name, file);
			model.addAttribute("userInfoList",resultList);
		}
		return "PreFileUpload";
	}
	
	@RequestMapping(value="/batchimport3.shtml",method=RequestMethod.POST)
	public String batchImport3(@RequestParam(value="filename")MultipartFile file,
			HttpServletRequest request,HttpServletResponse response,Model model){
		String titles="name,password,username,email";
		//判断文件是否为空
		if(file==null){
			model.addAttribute("msg","文件不能为空");
		}else{
			//获取文件名
			String name=file.getOriginalFilename();
			long size=file.getSize();
			if(name==null || "".equals(name) && size==0){
				model.addAttribute("msg","文件不能为空");
			}
			List<Map<String,Object>> resultList=fileUploadService.batchImport3(name, file,titles);
			model.addAttribute("userInfoList",resultList);
			
		}
		return "PreFileUpload";
	}
	
	@RequestMapping(value="getAllRecord.shtml",method=RequestMethod.POST)
	@ResponseBody
	public DataGridResult getAllRecord(Integer page ,Integer rows){
		Map<String, Object> resultMap=new HashMap<>();
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("page",page);
		paramMap.put("rows",rows);
		DataGridResult result=fileUploadService.getAllRecord(paramMap);
		return result;
	}
	
	/**
	 * 数据导入数据库
	 * @param userInfo
	 * @return
	 */
	@RequestMapping(value="/importData.shtml",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> importData(UserInfo userInfo,HttpServletRequest request){
		Map<String, Object> resultMap=new HashMap<>();
		Map<String,Object> paramMap=getParamMap(request.getParameterMap());
		if(fileUploadService.addRecordData(paramMap)==1){
			resultMap.put("msg","保存成功");
		}else{
			resultMap.put("msg","保存失败");
		}
		
		return resultMap;
	}
	
	
	//得到参数Map
	private Map<String,Object> getParamMap(Map<String,Object> requestMap){
		Map<String,Object> paramMap=new HashMap<>();
		for(String key:requestMap.keySet()){
			if(requestMap.get(key) instanceof String[]){
				if(((String[])requestMap.get(key)).length>0){
					paramMap.put(key,((String[])requestMap.get(key))[0]);
				}
			}
		}
		return paramMap;
	}
	
	//============================================================
	
	@SuppressWarnings({ "unused", "rawtypes" })
	/*@Resource(name="reportService")
	private ReportManager reportService;
	
	*//**
	 * 导出报表
	 */
	@RequestMapping(value="/export.shtml")
	@ResponseBody
	public void export(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		String content[][]=null;
		//获取数据
		List  result=fileUploadService.getAllData();
		//excel标题
		String [] title={"姓名","性别","年龄","学校","班级"};
		//excel文件名
		String fileName="学生信息表"+System.currentTimeMillis()+".xls";
		//sheet名
		String sheetName="学生信息表";
		System.out.println("list:"+result);
		
		String [][] array=new String[result.size()][];
		int len=array.length;
		System.out.println("len:"+len);
		for(int i=0;i<len;i++){
			Map map=(Map)result.get(i);
			Set set=map.keySet();
			array[i]=new String[map.size()];
			Iterator it=set.iterator();
			for(int j=0;it.hasNext();j++){
				String s=(String)it.next();
				if(map.get(s)!=null){
					array[i][j]=map.get(s).toString();
				}
			}
		}
		
		return;
		/*for(int i=0;i<list.size();i++){
			content[i]=new String[title.length];
			UserInfo userInfo=(UserInfo)list.get(i);
		}*/
		
	}
	
	
	@RequestMapping( value="/export1.shtml",method=RequestMethod.GET)
	public void ExportExcel2(HttpServletResponse response,@RequestParam(value="exportType")String exportType){
		try {
			System.out.println();
			System.out.println("===="+exportType);
			ExcelUtil.POITest2(response,exportType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
