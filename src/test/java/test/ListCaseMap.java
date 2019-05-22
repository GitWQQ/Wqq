package test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.ssm.dufy.web.common.CommonController;

public class ListCaseMap {

	
	@Test
	public void getShiroSession(HttpServletResponse response,HttpServletRequest request){
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		CommonController commonController=context.getBean(CommonController.class);
		commonController.getGifCode(response, request);
	}
}
