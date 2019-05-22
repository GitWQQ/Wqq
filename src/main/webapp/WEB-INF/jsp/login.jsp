<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%
//path就是获取的项目名 
String path=request.getContextPath();
String contextPath=request.getContextPath();
//request.getScheme()是获取协议（http协议） request.getServerName()获取服务名（服务器 ip） request.getServerPort()获取服务器端口号   
String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title></title>
        <base href="<%=basePath%>">
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <link   type="text/css" rel="stylesheet" href="js/easyui1.6/themes/icon.css" >
        <link   type="text/css" rel="stylesheet" href="js/easyui1.6/themes/default/easyui.css">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/easyui1.6/jquery.min.js"></script>
        <script type="text/javascript" src="js/easyui1.6/jquery.easyui.min.js"></script>
        <script type="text/javascript" src="js/easyui1.6/locale/easyui-lang-zh_CN.js"></script>
    </head>
    <body style="background-color: #F3F3F3">
    <div class="easyui-dialog" title="管理员登录" data-options="closable:false,draggable:false" style="width:400px;height:330px;padding:10px;">
       	<div style="margin-left: 50px;margin-top: 50px;">
       		<div style="margin-bottom:20px;">
	            <div>
	            	用户名: <input id="username" name="username" class="easyui-textbox"  data-options="iconCls:'icon-man'" style="width:200px;height:32px" />
	            </div>
	        </div>
	        <div style="margin-bottom:20px">
	            <div>
	            	密&nbsp;码: <input id="password" name="password" class="easyui-textbox" type="password" style="width:200px;height:32px" data-options="iconCls:'icon-lock'" />
	            </div>
	        </div>
	        <div>
	        	<input id="rememberMe" type="checkbox" style="margin-left:50px;margin-bottom:20px;"/>记住密码
	        	<br/>
	            <a id="loginsubmit" class="easyui-linkbutton" iconCls="icon-ok" style="width:200px;height:32px;margin-left: 50px">登录</a>
	        </div>
       	</div>
    </div>
    <script type="text/javascript">
    	$(function(){
			
    	})
    </script>
    <script type="text/javascript">
    	var ctx='<%=contextPath%>';
    	$.post(ctx+"/doLoginjsp.shtml");
    	$(function(){
    		$("#loginsubmit").click(function(){
    			LOGIN.login();
    		});
    	});
    	function progress(){
    		$.messager.progress({
    			title:'登陆进度',
    			msg:'loging.....',
    			text:'正在登陆',
    			interval:5000
    		}); 
    	}
    	
    	var LOGIN={
    			checkInput:function(){
    				if($("#userName").val()==""){
    					$.messager.alert("警告","   用户名不能为空","warning");
    					$("#userName").focus();
    					return false;
    				}
    				if($("#pwd").val()==""){
    					$.messager.alert("警告","密码不能为空","warning");
    					$("#pwd").focus();
    					return false;
    				}
    				return true;
    			},/* $("#formlogin").serialize() */
    			doLogin:function(){
					$.messager.progress();//开启进度条
    				var redirectUrl=window.location.protocol+"//"+window.location.host+"/";
    				var userName=$("#username").textbox("getValue");
    				var pwd=$("#password").textbox("getValue");
    				var data={"username":userName,"password":pwd,"rememberMe":$("#rememberMe").is(":checked")};
    				$.ajax({
    					type:"POST",
    					//url:ctx+"/doLoginjsp.shtml",
    					url:ctx+"/doLoginjsp.shtml",
    					data:data,
    					dataType:'json',
    					success:function(data){
    						$.messager.progress('close');//关闭进度
    						//登陆成功
    						if(data.status==200){
    							window.location.href=ctx+"/main.shtml";
    						}else{
    							$.messager.alert("警告",data.message,"warning");
    						}
    					},
    					error:function(data){
    							$.messager.progress('close');
    							$.messager.alert("警告","请求出错","info","error");
    					}
    				});	
    			},
    			login:function(){
    	    		if(this.checkInput()){
    	    			this.doLogin();
    	    		}		
    	    	}		
    	};
    </script>
</body>
</html>
