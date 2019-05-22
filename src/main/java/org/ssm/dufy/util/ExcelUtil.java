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
	 * ����Excel
	 * 
	 */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName,
			String [] title,String [] [] values,HSSFWorkbook wb){
		//��һ��������һ��HSSFWorkbook����Ӧһ��Excel�ļ�
		if(wb==null){
			wb=new HSSFWorkbook();
		}
		//�ڶ�������workbook�����һ��sheet,��ӦExcel�ļ���sheet
		HSSFSheet sheet=wb.createSheet(sheetName);
		//����������sheet����ӱ�ͷ��0�У�ע���ϰ汾poi��Excel����������
		HSSFRow row=sheet.createRow(0);
		//�ģ�������Ԫ�����ñ�ͷ�����ñ�ͷ����
		HSSFCellStyle style=wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		//�����ж���
		HSSFCell cell=null;
		//��������
		for(int i=0;i<title.length;i++){
			cell=row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		//��������
		for(int i=0;i<values.length;i++){
			row=sheet.createRow(i+1);
			for(int j=0;j<values[i].length;j++){
				//�����ݰ���˳��ֵ����Ӧ����
				row.createCell(j).setCellValue(values[i][j]);
			}
		}
		return wb;
	}
	
	
	public static  void POITest() throws FileNotFoundException{
		//����HSSFWorkbook����
		HSSFWorkbook workbook=new HSSFWorkbook();
		//����HSSFSheet����
		HSSFSheet sheet=workbook.createSheet("Sheet-one");
		//����HSSFRow����
		HSSFRow row=sheet.createRow(0);
		//����HSSFCell����
		HSSFCell cell=row.createCell(0);
		//���Cell��ֵ
		cell.setCellValue("Excel�ļ�����");
		//���Excel�ļ�
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
		//����HSSFWorkbook����
		HSSFWorkbook workbook=new HSSFWorkbook();
		//����Sheet����
		HSSFSheet sheet=workbook.createSheet("Test2");
		//��sheet����ӵ�һ�У�����Ϊ��������������0-65535֮������һ��
		HSSFRow row1=sheet.createRow(0);
		//������Ԫ��
		HSSFCell cell=row1.createCell(0);
		//���õ�Ԫ������
		cell.setCellValue("ѧԱ���Գɼ�һ����");
		//�ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У�������
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,3));
		//sheet�ﴴ���ڶ���
		HSSFRow row2=sheet.createRow(1);
		row2.createCell(0).setCellValue("����");
		row2.createCell(1).setCellValue("�༶");
		row2.createCell(2).setCellValue("���Գɼ�");
		row2.createCell(3).setCellValue("��ʱ�ɼ�");
		//������
		HSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("����");
		row3.createCell(1).setCellValue("A101");
		row3.createCell(2).setCellValue(87);
		row3.createCell(3).setCellValue(78);
		
		HSSFRow row4=sheet.createRow(2);
		row4.createCell(0).setCellValue("��С��");
		row4.createCell(1).setCellValue("A101");
		row4.createCell(2).setCellValue(87);
		row4.createCell(3).setCellValue(78);
		
		//���Excel�ļ�
		OutputStream outputStream=response.getOutputStream();
		response.reset();
	    response.setHeader("Content-disposition", "attachment; filename=details.xlsx");  
	    response.setContentType("application/msexcel");    
		try {
			System.out.println("��ӡ");
			workbook.write(outputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outputStream.close();
		outputStream.flush();
	}
	
	public static void exportExcel(String []titles,String filename,Object[][] exportData,HttpServletResponse response) throws IOException{
		//����Workbook
		HSSFWorkbook workbook=new HSSFWorkbook();
		//����Sheet
		HSSFSheet sheet =workbook.createSheet();
		//������,�������У���д����
		HSSFRow row=sheet.createRow(0);
		for(int i=0;i<titles.length;i++){
			HSSFCell cell=row.createCell(0);
			cell.setCellValue(titles[i].toString());
		}
		//����������
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
