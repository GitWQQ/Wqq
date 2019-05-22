package org.ssm.dufy.util;

import java.util.Calendar;

public interface Constant {
	//项目根路径
	static final String CONTEXT_PATH="contextPath";
	//当前年份
	static final int NOW_YEAY=Calendar.getInstance().get(Calendar.YEAR);
	
	/**地址**/
	static String VERSION=String.valueOf(System.currentTimeMillis());

	
}
