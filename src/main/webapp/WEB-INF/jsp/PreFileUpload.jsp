<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>批量导入客户</title>
	<base href="<%=basepath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
	<script type="text/javascript" src="js/easyui1.6/jquery.min.js"></script>
	<script language="javascript" src="js/online.js"></script>
	<script type="text/javascript" src="js/easyui1.6/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="js/easyui1.6/locale/easyui-lang-zh_CN.js"></script>
	<link type="text/css" href="js/easyui1.6/themes/default/easyui.css" rel="stylesheet"></script>
	<link type="text/css" href="js/easyui1.6/themes/icon.css" rel="stylesheet"></script>
</head>
<body style="background:#CEDFF3">
	<div style="width:100%">
		<form action="" method="POST"  id="form1">
		<table border="1px;" style="width:100%;">
				<tr>
					<th>NAME</th>
					<th>USERNAME</th>
					<th>PASSWORD</th>
					<th>EMAIL</th>
				</tr>
			<c:forEach items="${userInfoList}" var="item">
				<tr>
					<td>
						<input id="name" name="name" value="${item.name}"/>
					</td>
					<td>
						<input id="username" name="username" value="${item.username}"/>
					</td>
					<td>
						<input id="password" name="password" value="${item.password}"/>
					</td>
					<td>
						<input id="email" name="email" value="${item.email}"/>
					</td>
				</tr>
			</c:forEach>
		</table>
		</form>		
	</div>
	<div style="text-align:center;width:100%;margin-top:50px;">
		<input id="btn" type="button" name="submit" value="提交" style="width:100px;height:28px;"/>
	</div>
</body>
</html>	
	<script type="text/javascript">
		$(function(){
			var ctx="<%=basepath%>";
			$("#btn").click(function(){
				var data1=$("#form1").serialize();
				var data=$("#form1").serializeArray();
				var paramData="{";
				$.each(data,function(i,field){
					paramData+=field.name+":"+field.value;	
				})
				paramData+="}"
			
				$.ajax({
					type:'POST',
					url:ctx+'/importData.shtml',
					/* data:paramData, */
					data:paramData,
					dataType:'json',
					success:function(data){
						
					}
				})
			})
		})
	</script>
	