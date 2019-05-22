package org.ssm.dufy.util.freemarker;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.ssm.dufy.util.Constant;
import org.ssm.dufy.util.LoggerUtils;

public class MyFreeMarkerView  extends FreeMarkerView{
	
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		try{
			super.exposeHelpers(model, request);
		}catch(Exception e){
			LoggerUtils.fmtError(MyFreeMarkerView.class, e,"FreeMarkerViewExtend 加载父类出现异常请检查。");
		}
		model.put(Constant.CONTEXT_PATH,request.getContextPath());
		model.put("basePath",request.getContextPath());
		model.put("NOW_YEAY", Constant.NOW_YEAY);
		model.put("time",new Date().getTime());
		model.put("_v", Constant.VERSION);
	}
	
	public static void main(String[] args) {
		System.out.println(Constant.NOW_YEAY);
	}
}
