<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>

<%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basepath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<script type="text/javascript" src="js/easyui1.6/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui1.6/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="js/easyui1.6/locale/easyui-lang-zh_CN.js"></script>
	<script language="javascript" src="js/online.js"></script>
	<link type="text/css" href="js/easyui1.6/themes/default/easyui.css" rel="stylesheet"></script>
	<link type="text/css" href="js/easyui1.6/themes/icon.css" rel="stylesheet"></script>
	<link href="css/online.css" rel="stylesheet" type="text/css" />
	<title></title>
	<script type="text/javascript">
		$(function(){
			$("#log").click(function(){
				
			})
		})
	</script>
</head>
<body>
	<fieldset>
		<legend>###</legend>
		
		<shiro:guest>
			<h1>欢迎游客访问--<a id="log">登录</a></h1>
		</shiro:guest>
		
		<shiro:hasPermission name="admin">
		
		</shiro:hasPermission>	 
		<form action="<%=basepath%>login" method="POST" id="formLog">
			姓名：
			<input type="text" name="username" style="width:200px;height:20px;" />
			密码：
			<input type="password" name="password" style="width:200px;height:20px">
			<input type="submit" value="提交">
		</form>
		
	</fieldset>
	
</body>
</html>
