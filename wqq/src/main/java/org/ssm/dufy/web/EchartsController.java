package org.ssm.dufy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/echarts")
public class EchartsController {

	@RequestMapping("/toIndex")
	public String toIndex(){
		return "echarts/index";
	}
}
