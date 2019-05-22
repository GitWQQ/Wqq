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
    //������
    private int totalRows = 0;  
    //������
    private int totalCells = 0; 
    //������Ϣ������
    private String errorMsg;
    //���췽��
    public ReadExcel(){}
    //��ȡ������
    public int getTotalRows()  { return totalRows;} 
    //��ȡ������
    public int getTotalCells() {  return totalCells;} 
    //��ȡ������Ϣ
    public String getErrorInfo() { return errorMsg; }  
    
  /**
   * ��֤EXCEL�ļ�
   * @param filePath
   * @return
   */
  public boolean validateExcel(String filePath){
        if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath))){  
            errorMsg = "�ļ�������excel��ʽ";  
            return false;  
        }  
        return true;
  }
    
  /**
   * ��EXCEL�ļ�����ȡ�ͻ���Ϣ����
   * @param fielName
   * @return
   */
  public List<UserInfo> getExcelInfo(String fileName,MultipartFile Mfile){
      
      //��spring�ļ��ϴ���MultipartFileת����CommonsMultipartFile����
       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //��ȡ���ش洢·��
       File file = new  File("D:\\fileupload");
       //����һ��Ŀ¼ ������·�����ɵ�ǰ File ����ָ����������һ����ĸ�·������
       if (!file.exists()) file.mkdirs();
       //�½�һ���ļ�
       File file1 = new File("D:\\fileupload" + new Date().getTime() + ".xlsx"); 
       //���ϴ����ļ�д���½����ļ���
       try {
           cf.getFileItem().write(file1); 
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       //��ʼ���ͻ���Ϣ�ļ���    
       List<UserInfo> customerList=new ArrayList<UserInfo>();
       //��ʼ��������
       InputStream is = null;  
       try{
          //��֤�ļ����Ƿ�ϸ�
          if(!validateExcel(fileName)){
              return null;
          }
          //�����ļ����ж��ļ���2003�汾����2007�汾
          boolean isExcel2003 = true; 
          if(WDWUtil.isExcel2007(fileName)){
              isExcel2003 = false;  
          }
          //�����½����ļ�ʵ����������
          is = new FileInputStream(file1);
          //����excel��������ݶ�ȡ�ͻ���Ϣ
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
   * ��EXCEL�ļ�����ȡ�ͻ���Ϣ����
   * @param fielName
   * @return
   */
  public List<Map<String,Object>> getExcelInfo3(String fileName,MultipartFile Mfile,String titles){
      
      //��spring�ļ��ϴ���MultipartFileת����CommonsMultipartFile����
       CommonsMultipartFile cf= (CommonsMultipartFile)Mfile; //��ȡ���ش洢·��
       File file = new  File("D:\\fileupload");
       //����һ��Ŀ¼ ������·�����ɵ�ǰ File ����ָ����������һ����ĸ�·������
       if (!file.exists()) file.mkdirs();
       //�½�һ���ļ�
       File file1 = new File("D:\\fileupload" + new Date().getTime() + ".xlsx"); 
       //���ϴ����ļ�д���½����ļ���
       try {
           cf.getFileItem().write(file1); 
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       //��ʼ���ͻ���Ϣ�ļ���    
       List<Map<String,Object>> customerList=new ArrayList<Map<String,Object>>();
       //��ʼ��������
       InputStream is = null;  
       try{
          //��֤�ļ����Ƿ�ϸ�
          if(!validateExcel(fileName)){
              return null;
          }
          //�����ļ����ж��ļ���2003�汾����2007�汾
          boolean isExcel2003 = true; 
          if(WDWUtil.isExcel2007(fileName)){
              isExcel2003 = false;  
          }
          //�����½����ļ�ʵ����������
          is = new FileInputStream(file1);
          //����excel��������ݶ�ȡ�ͻ���Ϣ
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
   * ����excel��������ݶ�ȡ�ͻ���Ϣ
   * @param is ������
   * @param isExcel2003 excel��2003����2007�汾
   * @return
   * @throws IOException
   */
  public  List<Map<String,Object>> getExcelInfo3(InputStream is,boolean isExcel2003,String titles){
       List<Map<String,Object>> customerList=null;
       try{
           /** ���ݰ汾ѡ�񴴽�Workbook�ķ�ʽ */
           Workbook wb = null;
           //��excel��2003ʱ
           if(isExcel2003){
               wb = new HSSFWorkbook(is); 
           }
           else{//��excel��2007ʱ
               wb = new XSSFWorkbook(is); 
           }
           //��ȡExcel����ͻ�����Ϣ
           customerList=readExcelValue3(wb,titles);
       }
       catch (IOException e)  {  
           e.printStackTrace();  
       }  
       return customerList;
  }
  //==========================================
  /**
   * ����excel��������ݶ�ȡ�ͻ���Ϣ
   * @param is ������
   * @param isExcel2003 excel��2003����2007�汾
   * @return
   * @throws IOException
   */
  public  List<UserInfo> getExcelInfo(InputStream is,boolean isExcel2003){
       List<UserInfo> customerList=null;
       try{
           /** ���ݰ汾ѡ�񴴽�Workbook�ķ�ʽ */
           Workbook wb = null;
           //��excel��2003ʱ
           if(isExcel2003){
               wb = new HSSFWorkbook(is); 
           }
           else{//��excel��2007ʱ
               wb = new XSSFWorkbook(is); 
           }
           //��ȡExcel����ͻ�����Ϣ
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
 	  //�õ���һ��Sheet 
	  List<?> resultList=new ArrayList<>();
	  for(int i=0;i<workbook.getNumberOfSheets();i++){
		  Sheet sheet=workbook.getSheetAt(i);
		  if(sheet.getPhysicalNumberOfRows()!=0 && sheet.getLastRowNum()!=0){
			  //�õ�Excel������
			  this.totalRows=sheet.getPhysicalNumberOfRows();
			  if(totalRows>=1 && sheet.getRow(0)!=null){
				  //��ȡ����
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
   * ��ȡExcel����ͻ�����Ϣ
   * @param wb
   * @return
   */
  private List<UserInfo> readExcelValue(Workbook wb){ 
      //�õ���һ��shell  
	  List<UserInfo> userinfoList=new ArrayList<UserInfo>();
	  for(int i=0;i<wb.getNumberOfSheets();i++){
		  Sheet sheet=wb.getSheetAt(i);
		  if(sheet.getPhysicalNumberOfRows()!=0 && sheet.getLastRowNum()!=0){
			  
			  //�õ�Excel������
			  this.totalRows=sheet.getPhysicalNumberOfRows();
			  //��ȡ����,ǰ����������
			  if(totalRows>=1 && sheet.getRow(0)!=null){
				  this.totalCells=sheet.getRow(0).getPhysicalNumberOfCells();
			  }
		      UserInfo userInfo;
		      //ѭ��Excel����,�ӵڶ��п�ʼ�����ⲻ���
		      for(int r=1;r<totalRows;r++){
		    	  Row row=sheet.getRow(r);
		    	  if(row==null){ 
		    		  continue;
		    	  }else{
		    		  userInfo=new UserInfo();
			    	  //ѭ��Excel��
		    		  for(int c=0;c<this.totalCells;c++){
		    			  Cell cell=row.getCell(c);
		    			  cell.setCellType(Cell.CELL_TYPE_STRING);
		    			  if(null !=cell){
		    				  if(c==0){//��һ�в���
		                      }else if(c==1){
		                   	   userInfo.setName(cell.getStringCellValue());//�ͻ�����
		                      }else if(c==2){
		                   	   userInfo.setPassword(cell.getStringCellValue());//�ͻ����
		                      }else if(c==3){
		                   	   userInfo.setUsername(cell.getStringCellValue());//��ҵ
		                      }else if(c==4){
		                   	   userInfo.setEmail(cell.getStringCellValue());//�ͻ���Դ
		                      }  
		    			  }
		    		  }
		    		  //��ӿͻ�
		              userinfoList.add(userInfo);
		    	  }
		      }
		  }
	  	}
	  return  userinfoList;
  }
}