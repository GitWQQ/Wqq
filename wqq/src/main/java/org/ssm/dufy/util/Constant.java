package org.ssm.dufy.util;

import java.util.Calendar;

public interface Constant {
	//��Ŀ��·��
	static final String CONTEXT_PATH="contextPath";
	//��ǰ���
	static final int NOW_YEAY=Calendar.getInstance().get(Calendar.YEAR);
	
	/**��ַ**/
	static String VERSION=String.valueOf(System.currentTimeMillis());

	
}
