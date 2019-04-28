package org.ssm.dufy.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.ssm.dufy.entity.Goods;
import org.ssm.dufy.service.DemoService;

@Controller
@RequestMapping("/demo")
public class DemoController {
    
    @Autowired
   private  DemoService demoService;
   
    
    
    @RequestMapping("/list")
    @ResponseBody
    public void getAllRecord(HttpServletRequest request){
    	String id=request.getParameter("id");
    	String price=request.getParameter("price");
        //Goods  result=demoService.queryAllRecord(id);
    	System.out.println("id:"+id);
    	System.out.println("price:"+price);
    	demoService.updatePrice(Integer.valueOf(id),Integer.valueOf(price));
    	
    }
    
    @RequestMapping(value="/get/{id}",method=RequestMethod.GET)
    @ResponseBody
    public List getRecordById(@PathVariable String id){
    	List result=demoService.queryAllRecord(id);
    	return result;
    }
    
    @RequestMapping("/index")
    public String index(){
    	return "index";
    }

}
