<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	int i=1;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<base href="<%=basepath%>">
		<title>MongoDBTest</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<script type="text/javascript" src="js/easyui1.6/jquery.min.js"></script>
		<script type="text/javascript" src="js/easyui1.6/jquery.easyui.min.js"></script> 
		<script type="text/javascript" src="js/easyui1.6/locale/easyui-lang-zh_CN.js"></script>
		<script language="javascript" src="js/online.js"></script>
		<link type="text/css" href="js/easyui1.6/themes/default/easyui.css" rel="stylesheet"></script>
		<link type="text/css" href="js/easyui1.6/themes/icon.css" rel="stylesheet"></script>
		<link href="css/online.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript">
			$(function(){
				$("#select").click(function(){
					$.ajax({
						type:'GET',
						url:'<%=basepath%>/mongo/getEmpMap',
						dataType:'json',
						success:function(data){
							var list=data.Stus;
							for( var i=0;i<list.length;i++){
								var item=list[i];
								var template='<tr><td>'+item.name+'</td>'
											+'<td>'+item.age+'</td>'
											+'<td>'+item.gender+'</td>'
											+'<td></td></tr>';
								$("#tab").append(template);
							}
						}
					})	
				})
			});
		</script>
		<script type="text/javascript">
			function submitForm(){
				
			}
			function btn_submit(){
				//序列化参数
				var params=$("#sub").serializeArray();
				//发送ajax请求
				$.ajax({
					type:'POST',
					url:'<%=basepath%>/mongo/insert',
					data:params,
					dataType:'json',
					success:function(data){
						if(data.status==200){
							alert("添加成功");
						}
					},
					error:function(data){
						
					}
				})
			}
		</script>
		<script type="text/javascript">
		$(function(){
			var selectAll='<input type="checkbox" id="selectAll"/>全选';
			$("#easyui-tab").datagrid(
			{
				url:'<%=basepath%>/mongo/getEmpList',
				method:'GET',
				striped:true,
				pagination:true,
				toolbar:[{
					handler:function(){
					/* 	var chk='<input type="checkbox"/>';
						return chk;  */
					}
				}],
				columns:[[{
						field:'chk',
						title:selectAll,
						align:'center',
						width:80,
						formatter:function(value,row,index){
							var chk='<input type="checkbox" value="'+row.id+'"/>';
							return chk;
						}
					},{
						field:'name',
						title:'姓名',
						align:'center',
						width:100,
						formatter:function(value,row,index){
							return row.name;
						}
					},{
						field:'age',
						title:'性别',
						align:'center',
						width:100,
						formatter:function(value,row,index){
							return row.age;
						}
					},{
						field:'gender',
						title:'性别',
						align:'center',
						width:100,
						formatter:function(value,row,index){
							return row.gender;
						}
					},{
						field:'cz',
						title:'操作',
						width:100,
						align:'center',
						formatter:function(value,row,index){
							var btn='<a href="<%=basepath%>/mongo/delete?id='+row.id+'">删除</a>&nbsp;&nbsp;<a href="">修改</a>';
							return btn;
						}
					}
				     ]]
				});
			
			//----------------------
			 	$("#selectAll").click(function(){
			 		if(this.checked){
			 			
			 		}else{
			 			
			 		}
			 		
			 	})
			})	
		</script>
	</head>
	<body>
		<fieldset style="width:500px;border:1px solid red;">
			<legend>###</legend>
		<form id="sub"  method="post" >
			<table width="500px">
				<tr>
					<th>姓名</th>
					<th>年龄</th>
					<th>性别</th>
				</tr>
				<tr>
					<td>
						<input type="text" name="name" id="name" required="required">
					</td>
					<td>
						<input type="text" name="age" id="age" required="required">
					</td>
					<td>
						<input type="text" name="gender" id="gender" required="required"/>
					</td>			
				</tr>
				<tr>
					<td>
						<input type="button" value="提交" onclick="btn_submit()">
					</td>
					<td colspan="2">
						<input type="button" value="查询" onclick="select()" id="select">
					</td>
				</tr>
			</table>	
		</form>
		</fieldset>
		<fieldset  style="width:500px">
			<legend>###查询结果###</legend>
			<table  style="width:500px" border="1px;" id="tab">
				<tr>
					<th>姓名</th>
					<th>年龄</th>
					<th>性别</th>
					<th>操作</th>
				</tr>
			</table>
		</fieldset>
		<fieldset style="width:600px;">
			<legend>####</legend>
			<table id="easyui-tab" style="width:600px">
			
			</table>
			
		</fieldset>
		<hr/>
		<form action="" method="POST">
			<input type="submit" value="提交"/>
		</form>
	</body>
</html>