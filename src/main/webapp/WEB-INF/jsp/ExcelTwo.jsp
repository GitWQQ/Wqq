<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	//response.setHeader("Content-Disposition", "attachment;filename=统计.xls");

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
		<script type="text/javascript">
			function check(){
				var start_val=$("#startTime").val().trim();
				var end_val=$("#endTime").val().trim();
				if(start_val==null || start_val==""){
					return;
				}
				if(end_val==null || end_val==""){
					return;
				}
			}
			function downLoad(){
				window.open('<%=basepath%>downLoad.shtml');
			}
			
		</script>		
	</head>
	<body>
		<div>
			<form action="" accept="" onsubmit="return check();">
				起始日期：
				<input id="startTime" name="startTime"  class="Wdate" style="width:200px;height:25px;"
				onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})"/>
				结束日期：
				<input id="endTime" name="endTime" class="Wdate" style="width:200px;height:25px;"
				onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})">
				<input type="submit" value="查询" style="width:100px;">
				<span id="span"></span>
			</form>
			
		</div>
		<hr/>
		<div style="width:100%">
			<input id="downLoad" onclick="downLoad();" type="button" value="下载" style="width:100px;">
			<table style="width:100%" cellpadding="1" border="1px;" >
				<tr>
					<th></th>
					<th colspan="4">查获</th>
					<th colspan="4">强制隔离戒毒</th>
				</tr>
				<tr>
					<th style="width:200px;">单位</th>
					<th>2017年9月26-2017年11月20</th>
					<th>2018年9月26-201年11月20</th>
					<th width="100px">同比</th>
					<th width="100px">环比</th>
					<th>2017年9月26-2017年11月20</th>
					<th>2018年9月26-201年11月20</th>
					<th width="100px">同比</th>
					<th width="100px">环比</th>
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
