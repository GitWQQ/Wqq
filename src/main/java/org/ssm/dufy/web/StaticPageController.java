package org.ssm.dufy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class StaticPageController {

	@RequestMapping("/ExcelTwo.shtml")
	public String  toExcelTwo(){
		return "ExcelTwo";
	}
	
	@RequestMapping("/downLoad.shtml")
	public String toDownLoadPage(){
		return "ExcelTwoDownLoad";
	}
}
