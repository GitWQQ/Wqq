package org.ssm.dufy.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kf")
public class KfController {
	
	@RequestMapping("/kfPage")
	public String toKfPage(){
		return "kf";
	}
	
	@RequestMapping("/getUser")
	public String toUser(){
		return "getUser";
	}
	
	/**
	 * ∑¢ÀÕ‘⁄œﬂ¡Ù—‘
	 * @return
	 */ 
	public Map<String,Object> toSendOnLineMessage(HttpServletRequest request){
		Map<String,Object> resultMap=new HashMap<String,Object>();
		Map<String,Object> paramMap=getParamMap(request.getParameterMap());
		
		return resultMap;
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
