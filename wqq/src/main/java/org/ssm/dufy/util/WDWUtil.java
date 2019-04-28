package org.ssm.dufy.util;

public class WDWUtil {

	//@�������Ƿ���2003��excel,����true��2003
	public static boolean isExcel2003(String filePath){
		return filePath.matches("^.+\\.(?i)(xls)$");
	}
	
	//@�������Ƿ���2007��excel,����true��2007
	public static boolean isExcel2007(String filePath){
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
	
	public static void main(String[] args) {
		System.out.println(isExcel2003("123.xlsx"));
		String string="123";
		System.out.println(string.matches("^123$"));
	}
}
