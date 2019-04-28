package org.ssm.dufy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.ssm.dufy.entity.UserInfo;


public class ReadExcel {
    //总行数
    private int totalRows = 0;  
    //总条数
    private int totalCells = 0; 
    //错误信息接收器
    private String errorMsg;
    //构造方法
    public ReadExcel(){}
    //获取总行数
    public int getTotalRows()  { return totalRows;} 
    //获取总列数
    public int getTotalCells() {  return totalCells;} 
    //获取错误信息
    public String getErrorInfo() { return errorMsg; }  
    
  /**
   * 验证EXCEL文件
   * @param filePath
   * @return
   */
  public boolean validateExcel(String filePath){
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){  
            errorMsg = "文件名不是excel格式";  
            return false;  
        }  
        return true;
  }
    
  /**
   * 读EXCEL文件，获取客户信息集合
   * @param fielName
   * @return
   */
  public List<UserInfo> getExcelInfo(String fileName,MultipartFile Mfile){
      
      //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
       File file = new  File("D:\\fileupload");
       //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
       if (!file.exists()) file.mkdirs();
       //新建一个文件
       File file1 = new File("D:\\fileupload" + new Date().getTime() + ".xlsx"); 
       //将上传的文件写入新建的文件中
       try {
           cf.getFileItem().write(file1); 
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       //初始化客户信息的集合    
       List<UserInfo> customerList=new ArrayList<UserInfo>();
       //初始化输入流
       InputStream is = null;  
       try{
          //验证文件名是否合格
          if(!validateExcel(fileName)){
              return null;
          }
          //根据文件名判断文件是2003版本还是2007版本
          boolean isExcel2003 = true; 
          if(WDWUtil.isExcel2007(fileName)){
              isExcel2003 = false;  
          }
          //根据新建的文件实例化输入流
          is = new FileInputStream(file1);
          //根据excel里面的内容读取客户信息
          customerList = getExcelInfo(is, isExcel2003); 
          is.close();
      }catch(Exception e){
          e.printStackTrace();
      } finally{
          if(is !=null)
          {
              try{
                  is.close();
              }catch(IOException e){
                  is = null;    
                  e.printStackTrace();  
              }
          }
      }
      return customerList;
  }
  
 // =======================================
  /**
   * 读EXCEL文件，获取客户信息集合
   * @param fielName
   * @return
   */
  public List<Map<String,Object>> getExcelInfo3(String fileName,MultipartFile Mfile,String titles){
      
      //把spring文件上传的MultipartFile转换成CommonsMultipartFile类型
       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //获取本地存储路径
       File file = new  File("D:\\fileupload");
       //创建一个目录 （它的路径名由当前 File 对象指定，包括任一必须的父路径。）
       if (!file.exists()) file.mkdirs();
       //新建一个文件
       File file1 = new File("D:\\fileupload" + new Date().getTime() + ".xlsx"); 
       //将上传的文件写入新建的文件中
       try {
           cf.getFileItem().write(file1); 
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       //初始化客户信息的集合    
       List<Map<String,Object>> customerList=new ArrayList<Map<String,Object>>();
       //初始化输入流
       InputStream is = null;  
       try{
          //验证文件名是否合格
          if(!validateExcel(fileName)){
              return null;
          }
          //根据文件名判断文件是2003版本还是2007版本
          boolean isExcel2003 = true; 
          if(WDWUtil.isExcel2007(fileName)){
              isExcel2003 = false;  
          }
          //根据新建的文件实例化输入流
          is = new FileInputStream(file1);
          //根据excel里面的内容读取客户信息
          customerList = getExcelInfo3(is, isExcel2003,titles); 
          is.close();
      }catch(Exception e){
          e.printStackTrace();
      } finally{
          if(is !=null)
          {
              try{
                  is.close();
              }catch(IOException e){
                  is = null;    
                  e.printStackTrace();  
              }
          }
      }
      return customerList;
  }
 //=========================================== 
  /**
   * 根据excel里面的内容读取客户信息
   * @param is 输入流
   * @param isExcel2003 excel是2003还是2007版本
   * @return
   * @throws IOException
   */
  public  List<Map<String,Object>> getExcelInfo3(InputStream is,boolean isExcel2003,String titles){
       List<Map<String,Object>> customerList=null;
       try{
           /** 根据版本选择创建Workbook的方式 */
           Workbook wb = null;
           //当excel是2003时
           if(isExcel2003){
               wb = new HSSFWorkbook(is); 
           }
           else{//当excel是2007时
               wb = new XSSFWorkbook(is); 
           }
           //读取Excel里面客户的信息
           customerList=readExcelValue3(wb,titles);
       }
       catch (IOException e)  {  
           e.printStackTrace();  
       }  
       return customerList;
  }
  //==========================================
  /**
   * 根据excel里面的内容读取客户信息
   * @param is 输入流
   * @param isExcel2003 excel是2003还是2007版本
   * @return
   * @throws IOException
   */
  public  List<UserInfo> getExcelInfo(InputStream is,boolean isExcel2003){
       List<UserInfo> customerList=null;
       try{
           /** 根据版本选择创建Workbook的方式 */
           Workbook wb = null;
           //当excel是2003时
           if(isExcel2003){
               wb = new HSSFWorkbook(is); 
           }
           else{//当excel是2007时
               wb = new XSSFWorkbook(is); 
           }
           //读取Excel里面客户的信息
           customerList=readExcelValue(wb);
       }
       catch (IOException e)  {  
           e.printStackTrace();  
       }  
       return customerList;
  }
  //===================================
  private List<Map<String,Object>> readExcelValue3(Workbook workbook,String titles){
	  String [] title=titles.split(",");
	  Map<String,Object> resultMap=null;
	  List<Map<String,Object>> list2=new ArrayList<>();
 	  //得到第一个Sheet 
	  List<?> resultList=new ArrayList<>();
	  for(int i=0;i<workbook.getNumberOfSheets();i++){
		  Sheet sheet=workbook.getSheetAt(i);
		  if(sheet.getPhysicalNumberOfRows()!=0 && sheet.getLastRowNum()!=0){
			  //得到Excel的行数
			  this.totalRows=sheet.getPhysicalNumberOfRows();
			  if(totalRows>=1 && sheet.getRow(0)!=null){
				  //获取列数
				  this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
			  }
			  for (int r =1; r <this.totalRows; r++) {
				  resultMap=new HashMap<>();
				  Row row=sheet.getRow(r);
				  if(row==null) continue;
				  for(int c=1;c<this.totalCells;c++){
					  Cell cell=row.getCell(c);
					  cell.setCellType(Cell.CELL_TYPE_STRING);
					  resultMap.put(title[c-1],cell.getStringCellValue());
				  }
				  list2.add(resultMap);
			  }
		  }
	  }
	  return list2;
  }
  
  //=====================================================
  /**
   * 读取Excel里面客户的信息
   * @param wb
   * @return
   */
  private List<UserInfo> readExcelValue(Workbook wb){ 
      //得到第一个shell  
	  List<UserInfo> userinfoList=new ArrayList<UserInfo>();
	  for(int i=0;i<wb.getNumberOfSheets();i++){
		  Sheet sheet=wb.getSheetAt(i);
		  if(sheet.getPhysicalNumberOfRows()!=0 && sheet.getLastRowNum()!=0){
			  
			  //得到Excel的行数
			  this.totalRows=sheet.getPhysicalNumberOfRows();
			  //获取列数,前提是有行数
			  if(totalRows>=1 && sheet.getRow(0)!=null){
				  this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
			  }
		      UserInfo userInfo;
		      //循环Excel行数,从第二行开始。标题不入库
		      for(int r=1;r<totalRows;r++){
		    	  Row row=sheet.getRow(r);
		    	  if(row==null){ 
		    		  continue;
		    	  }else{
		    		  userInfo=new UserInfo();
			    	  //循环Excel列
		    		  for(int c=0;c<this.totalCells;c++){
		    			  Cell cell=row.getCell(c);
		    			  cell.setCellType(Cell.CELL_TYPE_STRING);
		    			  if(null !=cell){
		    				  if(c==0){//第一列不读
		                      }else if(c==1){
		                   	   userInfo.setName(cell.getStringCellValue());//客户名称
		                      }else if(c==2){
		                   	   userInfo.setPassword(cell.getStringCellValue());//客户简称
		                      }else if(c==3){
		                   	   userInfo.setUsername(cell.getStringCellValue());//行业
		                      }else if(c==4){
		                   	   userInfo.setEmail(cell.getStringCellValue());//客户来源
		                      }  
		    			  }
		    		  }
		    		  //添加客户
		              userinfoList.add(userInfo);
		    	  }
		      }
		  }
	  	}
	  return  userinfoList;
  }
}