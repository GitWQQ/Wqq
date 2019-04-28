<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	查看<a href="<%=request.getContextPath()%>/cacheTest/get/2" target="_blank">2号</a>用户名
	<br/>
	<br/>
	查看<a href="<%=request.getContextPath()%>/cacheTest/get/3" target="_blank">3号</a>用户名
	<br/>
	<br/>
	更新<a href="<%=request.getContextPath()%>/cacheTest/update/3" target="_blank">3号</a>用户名
	<br/>
	<br/>
	移除<a href="<%=request.getContextPath()%>/cacheTest/removeAll" target="_blank">所有</a>用户名
	下面是getUser.jsp
	
</body>   
</html>