<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ taglib  uri="http://www.tag.com/mytag" prefix="mytag" %>
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
	<script type="text/javascript" src="js/pinyin.js"></script>
	<script type="text/javascript" src="js/easyui1.6/jquery.easyui.min.js"></script> 
	<script type="text/javascript" src="js/easyui1.6/locale/easyui-lang-zh_CN.js"></script>
	<script language="javascript" src="js/online.js"></script>
	<link type="text/css" href="js/easyui1.6/themes/default/easyui.css" rel="stylesheet"></script>
	<link type="text/css" href="js/easyui1.6/themes/icon.css" rel="stylesheet"></script>
	<link href="css/online.css" rel="stylesheet" type="text/css" />
	<title></title>
	<style type="text/css">
		hr{
			border-color:red;
		}
	</style>
</head>

<script type="text/javascript">
	$(function(){
		
		$("#demo").combotree({
			url:"combotree/getDwdm?dwdm=340000000000",
			onBeforeExpand: function(node){  //在节点展开之前触发，返回false可以取消展开操作。
				$("#demo").combotree("tree").tree("options").url="combotree/getDwdm?dwdm="+node.id;
			},
			onSelect:function(node){
				$("#demo").attr("value",node.text);
			} 
		})
	})
</script>
<body>
	<div style="margin:0px;height:60px;width:100%;background-color:#808080;align:right;">
		<span style="float:left;margin-left:100px;margin-top:15px;font-size:23px;">欢迎【<shiro:principal property="username"/>】光临</span>
		<a href="<%=basepath%>logout.shtml" style="float:right; margin-top:15px;margin-right:100px;
		color:#fff121;font-size:23px;width:100px;text-decoration:none">【<font style="color:blue;font-weight:bold;">注销</font>】</a>
	</div>
	<div>
		<mytag:Helloworld/>
		<mytag:Helloworld/>
		<shiro:hasRole name="vip">
			<span style="font-size:30px;">
				Shiro用户：【<shiro:principal property="username"/>】
			<br>
				Shiro角色：VIP
			</span>
			<br>
			<shiro:hasPermission name="userInfo:del">
			<span style="font-size:30px;">Shiro权限：您拥有USERINFO:DEL权限</span>
			</shiro:hasPermission>
		</shiro:hasRole>
		<br/>
		<hr>
		<input  id="cc1" class="easyui-combobox" style="width:200px;height:28px;" data-options="url:'pcd/getPcd?pid=0',
			method:'GET',
			valueField:'id',
			textField:'name',
			filter:function(q,row){
				var opts = $(this).combobox('options');
				return (row[opts.valueField].indexOf(q)==0)||(row[opts.textField].indexOf(q)==0);},
			formatter:function(row){
				var opts=$(this).combobox('options');
				return row[opts.valueField]+'|'+row[opts.textField];},
			onSelect:function(rec){
				var url='pcd/getPcd?pid='+rec.id;
				$('#cc2').combobox('reload', url);    
			}	
		"/>
		<input id="cc2" class="easyui-combobox" data-options="valueField:'id',
			textField:'name',
			formatter:function(row){
				var opts=$(this).combobox('options');
				return row[opts.valueField]+'|'+row[opts.textField];
			},
			onSelect:function(rec){
				var url='pcd/getPcd?pid='+rec.id;
				$('#cc3').combobox('reload',url);
			}
		" />  
		<input id="cc3" class="easyui-combobox" data-options="
			valueField:'id',
			textField:'name',
			formatter:function(row){
				var opts=$(this).combobox('options');
				return row[opts.valueField]+'|'+row[opts.textField];
			}
		">
		<div style="margin:20px 0;">
			<button id="start">Start</button>
		</div>
		<div id="p" class="easyui-progressbar" style="width:400px;"></div>
		<div>
			<input id="demo" style="width:400px;height:28" ></input>
			<input id="demo2" style="width:200px;height:28px;"></input>
		</div>
		<div>
			<input id="demo3" style="width:200px; height:38"/>
			<input id="demo4" style="width:200px; height:38"/>
		</div>
		<div id="onService_panel"> 
			<%@include  file="kfPage.jsp"%>
		</div>
		<hr>
		<div>
			<a href="echarts.shtml"><font style="font-size:20px;">【echarts】</font></a>
		</div>
		<hr>
		<div>
			<a href="excel.shtml"><font style="font-size:20px;">【	Excel】</font></a>
		</div>
		<div>
			<a id="a_btn"><font style="font-size:20px;">导出</font></a>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	$(function(){
		$("#echartsLink").click(function(){
			window.open('echarts.jsp');
		})
		$("#start").click(function(){
			 var value = $('#p').progressbar('getValue');
			if (value < 100){
				value += Math.floor(Math.random() * 10);
				$('#p').progressbar('setValue', value);
				setTimeout(arguments.callee, 200);
			}
		})
		$("#a_btn").click(function(){
			window.open('<%=basepath%>ExcelTwo.shtml','_blank');
		})
		
		//--------------------------------------------
		$("#demo2").combotree({
			data:[{
				"id":1,
				"text":"City",
				"children":[{
					"id":11,
					"text":"Wyoming",
					"children":[{
						"id":111,
						"text":"Albin"
					},{
						"id":112,
						"text":"Canon"
					},{
						"id":113,
						"text":"Egbert"
					}]
				},{
					"id":12,
					"text":"Washington",
					"state":"closed",
					"children":[{
						"id":121,
						"text":"Bellingham"
					},{
						"id":122,
						"text":"Chehalis"
					},{
						"id":123,
						"text":"Ellensburg"
					},{
						"id":124,
						"text":"Monroe"
					}]
				}]
			}]
		});
	})
	</script>
	<script type="text/javascript">
		$(function(){
			$("#demo3").blur(function(){
				var val=$("#demo3").val();
				var result=getPinYinFirstCharacter(val,true);
				$("#demo4").val(result);
			});
			
		});
	</script>
	
