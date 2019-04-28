package org.ssm.dufy.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.ssm.dufy.service.impl.CacheTestServiceImpl;

@Controller
@RequestMapping("cacheTest")
public class CacheTestController {
	
	@Resource
	private CacheTestServiceImpl cacheTestServiceImpl;
	
	@RequestMapping(value="/get/{userNo}", method=RequestMethod.GET)
	public String get(@PathVariable String userNo, Model model){
		String username = cacheTestServiceImpl.get(userNo);
		model.addAttribute("username", username);
		return "getUser";
	}

	@RequestMapping(value="/update/{userNo}", method=RequestMethod.GET)
	public String update(@PathVariable String userNo, Model model){
		cacheTestServiceImpl.update(userNo);
		model.addAttribute("userNo", userNo);
		return "updateUser";
	}
	

	@RequestMapping(value="/removeAll", method=RequestMethod.GET)
	public String removeAll(){
		cacheTestServiceImpl.removeAll();
		return "removeAllUser";
	}

	@RequestMapping("/toCache")
	public String toCachePage(){
		return "cache";
	}

}
