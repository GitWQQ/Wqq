package org.ssm.dufy.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.dufy.service.PcdService;

@Controller
@RequestMapping("/pcd")
public class PcdController {

	@Autowired
	private PcdService pcdService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/getPcd")
	@ResponseBody
	public List getPcdList(HttpServletRequest request){
		Map<String,Object> paramMap=getParamMap(request.getParameterMap());
		Map<String,Object> resultMap=new HashMap<String,Object>();
		List resultList=pcdService.queryByParam(paramMap);
		if(resultList !=null){
			resultMap.put("resultList",resultList);
			resultMap.put("success",true);
		}
		return  resultList;
	}
	
	public Map<String,Object> getParamMap(Map<String, Object> requestMap){
		Map<String,Object> paramMap=new HashMap<String,Object>();
		for(String key:requestMap.keySet()){
			if(requestMap.get(key) instanceof String[]){
				if(((String[])requestMap.get(key)).length>0){
					paramMap.put(key,((String[])requestMap.get(key))[0]);
				}
			}
		}
		return paramMap;
	}
}
