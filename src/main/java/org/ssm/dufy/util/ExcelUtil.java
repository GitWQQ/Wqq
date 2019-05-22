package org.ssm.dufy.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.ssm.dufy.entity.UserInfo;

public class ExcelUtil {

	/**
	 * 导出Excel
	 * 
	 */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName,
			String [] title,String [] [] values,HSSFWorkbook wb){
		//第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if(wb==null){
			wb=new HSSFWorkbook();
		}
		//第二步，在workbook中添加一个sheet,对应Excel文件的sheet
		HSSFSheet sheet=wb.createSheet(sheetName);
		//第三步，在sheet中添加表头第0行，注意老版本poi对Excel的行数列数
		HSSFRow row=sheet.createRow(0);
		//四，创建单元格，设置表头，设置表头居中
		HSSFCellStyle style=wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//声明列对象
		HSSFCell cell=null;
		//创建标题
		for(int i=0;i<title.length;i++){
			cell=row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		//创建内容
		for(int i=0;i<values.length;i++){
			row=sheet.createRow(i+1);
			for(int j=0;j<values[i].length;j++){
				//将内容按照顺序赋值给对应的列
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		return wb;
	}
	
	
	public static  void POITest() throws FileNotFoundException{
		//创建HSSFWorkbook对象
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建HSSFSheet对象
		HSSFSheet sheet=workbook.createSheet("Sheet-one");
		//创建HSSFRow对象
		HSSFRow row=sheet.createRow(0);
		//创建HSSFCell对象
		HSSFCell cell=row.createCell(0);
		//填充Cell的值
		cell.setCellValue("Excel文件测试");
		//输出Excel文件
		try {
			FileOutputStream fStream=new FileOutputStream("D:\\"+System.currentTimeMillis()+"POITest.xlsx");
			workbook.write(fStream);
			fStream.flush();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public  static void POITest2(HttpServletResponse response ,String exportType) throws IOException{
		//创建HSSFWorkbook对象，
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建Sheet对象
		HSSFSheet sheet=workbook.createSheet("Test2");
		//在sheet里添加第一行，参数为行索引，可以是0-65535之间任意一个
		HSSFRow row1=sheet.createRow(0);
		//创建单元格，
		HSSFCell cell=row1.createCell(0);
		//设置单元格内容
		cell.setCellValue("学员考试成绩一览表");
		//合并单元格，CellRangeAddress构造参数依次表示起始行，截至行，起始列，截至列
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		//sheet里创建第二行
		HSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("姓名");
		row2.createCell(1).setCellValue("班级");
		row2.createCell(2).setCellValue("笔试成绩");
		row2.createCell(3).setCellValue("及时成绩");
		//第三行
		HSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("黎明");
		row3.createCell(1).setCellValue("A101");
		row3.createCell(2).setCellValue(87);
		row3.createCell(3).setCellValue(78);
		
		HSSFRow row4=sheet.createRow(2);
		row4.createCell(0).setCellValue("王小刘");
		row4.createCell(1).setCellValue("A101");
		row4.createCell(2).setCellValue(87);
		row4.createCell(3).setCellValue(78);
		
		//输出Excel文件
		OutputStream outputStream=response.getOutputStream();
		response.reset();
	    response.setHeader("Content-disposition", "attachment; filename=details.xlsx");  
	    response.setContentType("application/msexcel");    
		try {
			System.out.println("打印");
			workbook.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.close();
		outputStream.flush();
	}
	
	public static void exportExcel(String []titles,String filename,Object[][] exportData,HttpServletResponse response) throws IOException{
		//创建Workbook
		HSSFWorkbook workbook=new HSSFWorkbook();
		//创建Sheet
		HSSFSheet sheet =workbook.createSheet();
		//创建行,创建首行，填写标题
		HSSFRow row=sheet.createRow(0);
		for(int i=0;i<titles.length;i++){
			HSSFCell cell=row.createCell(0);
			cell.setCellValue(titles[i].toString());
		}
		//创建数据行
		for(int j=1;j<exportData.length;j++){
			HSSFRow row2=sheet.createRow(j);
			for(int c=0;c<row2.getPhysicalNumberOfCells();c++){
				HSSFCell cell=row2.createCell(c);
				cell.setCellValue(exportData[j][c].toString());
			}
		}
		OutputStream fos=response.getOutputStream();
		response.reset();
		response.setHeader("Content-disposition", "attachment; filename="+filename+".xlsx");
		response.setContentType("application/msexcel");
		workbook.write(fos);
		fos.flush();
		fos.close();
	}
	
	public static void main(String[] args) {
		/*try {
			POITest();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		List<UserInfo> userInfos=new ArrayList<>();
		userInfos.add(new UserInfo("123","tom","tom","tom.@qq.om","password","salt", "state",true,"123"));
		userInfos.add(new UserInfo("1231","tom1","tom1","tom1.@qq.om","password1","salt1", "state1",true,"1231"));
		userInfos.add(new UserInfo("1232","tom2","tom2","tom2.@qq.om","password2","sal2t2", "state2",true,"1232"));
		String [][] content=new String[userInfos.size()][];
		for(int i=0;i<content.length;i++){
			Map map=(Map)userInfos.get(i);
			Set set=map.keySet();
			content[i]=new String[map.size()];
			Iterator it=set.iterator();
			for(int j=0;it.hasNext();j++){
				String s=(String)it.next();
				if(map.get(s)!=null){
					content[i][j]=map.get(s).toString();
				}
			}
		}
		System.out.println("content:"+content);
	}
}
