<%@ page language="java" contentType="text/html; charset=GB2312" pageEncoding="GB2312"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%	
	String filename="ͳ��";
	response.setContentType( "application/vnd.ms-excel;charset=GB2312"); 
	response.setHeader("Content-Disposition", "attachment;filename="+new String(filename.getBytes("gb2312"),"iso8859-1")+".xls");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta content="application/vnd.ms-Excel" http-equiv="Content-Type"/>
		<script type="text/javascript" src="js/easyui1.6/jquery.min.js"></script>
		<script type="text/javascript" src="js/easyui1.6/jquery.easyui.min.js"></script> 
		<script type="text/javascript" src="js/easyui1.6/locale/easyui-lang-zh_CN.js"></script>
		<script type="text/javascript" src="js/My97DatePicker/My97DatePicker/WdatePicker.js"></script>
		<link type="text/css" href="js/easyui1.6/themes/default/easyui.css" rel="stylesheet"></script>
		<link type="text/css" href="js/easyui1.6/themes/icon.css" rel="stylesheet"></script>		
	</head>
	<body>
		<div style="width:100%">
			<table style="width:100%" cellpadding="1" border="1px;" >
				<tr>
					<th></th>
					<th colspan="4">���</th>
					<th colspan="4">ǿ�Ƹ���䶾</th>
				</tr>
				<tr>
					<th style="width:200px;">��λ</th>
					<th>2017��9��26-2017��11��20</th>
					<th>2018��9��26-201��11��20</th>
					<th width="100px">ͬ��</th>
					<th width="100px">����</th>
					<th>2017��9��26-2017��11��20</th>
					<th>2018��9��26-201��11��20</th>
					<th width="100px">ͬ��</th>
					<th width="100px">����</th>
				</tr>
				<%-- <c:forEach items="" var="" > --%>
				<tr>
					<td>1</td>
					<td>2</td>
					<td>3</td>
					<td>4</td>
					<td>5</td>
					<td>6</td>
					<td>7</td>
					<td>8</td>
					<td>9</td>
				</tr>
				<%-- </c:forEach> --%>
			</table>
		</div>
	</body>
</html>
