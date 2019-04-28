<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String importMsg="";
	if(request.getSession().getAttribute("msg")!=null){
		importMsg=request.getSession().getAttribute("msg").toString();
	}
	request.getSession().setAttribute("msg","");
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
	<div>
		<fieldset style="border:1px solid #808080;width:600px;">
			<legend><font color="blue">批量导入客户 </font></legend>
		 	<div><a  href="fileupload.xlsx" download>下载模板</a> </div>
			<form action="<%=basepath%>batchimport3.shtml" method="post" enctype="multipart/form-data" onsubmit="return check();" >
				<div style="margin:30px;">
					<input id="excel_file" type="file" name="filename" accepx="xlsx" size="80" />
					<input id="excel_button" type="submit" value="导入Excel"/>
				</div>
					<input id="importMsg" color="red" type="hidden" value="<%=importMsg%>"></input>
					<input type="hidden">
			</form>	
		</fieldset>
		<hr/>
		<fieldset>
			<legend>导入的数据</legend>
			<input id="btnExportExcel" type="button" value="导出Excel" style="width:100px;height:30px;">
			<input id="btnExportExcel2" type="button" value="导出Excel2" style="width:100px;height:30px;">
			<a id="btnExportExcel3"  style="width:100px;height:30px;">导出Excel</a>
			<select id="exportType" style="width:150px;height:30px;">
				<option value="image/bmp">BMP</option>
				<option value="image/gif">GIF</option>
				<option value="image/jpeg">JPEG</option>
				<option value="image/tiff">TIFF</option>
				<option value="image/x-dcx">DCX</option>
				<option value="image/x-pcx">PCX</option>
				<option value="text/html">HTML</option>
				<option value="text/plain">TXT</option>
				<option value="text/xml">XML</option>
				<option value="application/afp">AFP</option>
				<option value="application/pdf">PDF</option>
				<option value="application/rtf">RTF</option>
				<option value="application/msword">MSWORD</option>
				<option value="application/msexcel">MSEXCEL</option>
				<option value="application/vnd.ms-powerpoint">MSPOWERPOINT</option>
				<option value="application/wordperfect5.1">WORDPERFECT</option>
				<option value="application/vnd.lotus-wordpro">WORDPRO</option>
				<option value="application/vnd.visio">VISIO</option>
				<option value="application/vnd.framemaker">FRAMEMAKER</option>
				<option value="application/vnd.lotus-1-2-3">LOTUS123</option>
			</select>
			<table id="userInfoDataGrid"></table>
		</fieldset>
		<div>
			<input id="btn" type="button" value="点击"/>
		</div>
		<hr/>
		<form id="form2">
			
		</form>
	</body>
</html>
<script type="text/javascript">
	$(function(){
		
		var msg="";
		var v=$("#importMsg").val();
		if(v!=null){
			msg=$("#importMsg").text();
		}
		if(msg!=""){
			alert(msg);
		}
		//------------------------------------		
		//--------------------------------------
		$("#userInfoDataGrid").datagrid({
			method:'post',
			url:"<%=basepath%>getAllRecord.shtml",
			pagination:true,
			columns:[[
				{
					field:'name',
					title:'NAME',
					width:100,
					formatter:function(value,row,index){
						return row.name;
					} 
					
				},{
					field:'password',
					title:'PASSWORD',
					width:200,
					formatter:function(value,row,index){
						return row.password;
					} 
				},{
					field:'username',
					title:'USERNAME',
					width:200,
					formatter:function(value,row,index){
						return row.username;
					}
				},{
					field:'email',
					title:'EMAIL',
					width:200,
					formatter:function(value,row,index){
						return row.email;
					}
				}
			]]
		})
		
		$("#btnExportExcel").click(function(){
			//$.get(url,data,success(response,status,xhr),dataType);
			//url:必填，发送请求的Url ， data:请求参数，success(response,status,xhr),response包含来自请求的结果，status:包含请求的状态，xhr:包含XMLHttpRequest对象
			//dataType:规定预计的服务器返回的数据类型，默认的将智能会自动判断，可选类型：xml,html,text,script,json,jsonp
			//var val=$("#exportType").val();
			var params=$("#userInfoDataGrid").datagrid('options').queryParams;
			var fields=$("#form2").serializeArray();
			$.each(fields,function(i,field){
				params[field.name]=field.value;
			})
			$("#userInfoDataGrid").datagrid('reload');
			<%-- $.get("<%=basepath%>export.shtml",{"exportType":val}); --%>
		})
		$("#btnExportExcel2").click(function(){
			$.get("<%=basepath%>export.shtml");
		})
	})
	function check(){
		var excel_file=$("#excel_file").val();
		if(excel_file =="" || excel_file.length==0){
			alert('请选择文件');
			return false;
		}else{
			return true;
		}
	}
	
</script>