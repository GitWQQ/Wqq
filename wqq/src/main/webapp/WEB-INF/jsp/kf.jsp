<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base href="<%=basepath%>" />	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="x-ua-compatible" content="ie=7" />
	<script language="javascript" src="js/jquery-1.7.1.min.js"></script>
	<link href="css/online.css" rel="stylesheet" type="text/css" />
	<script language="javascript" src="js/online.js"></script>
	<title></title>
</head>
<body>
<div class="main">
	<div class="main_c" >
	<!--================================================================-->
		<div id="onService_panel"  style="border:2px solid red">
			<div class="onService_panel_s">
				<div class="online_boxs">
					<div class="boxs_t">
						<span class="boxs_t_l"></span><span class="boxs_t_m"></span><span class="boxs_t_r"></span>
					</div>
  					<div class="boxs_m_l">
    					<div class="boxs_m_r">
      						<div class="box_m_m">
        						<div id="onlineList">
          							<em class="online_close" id="onlineClose" title="关闭"></em>
          							<div class="online_open  " id="onlineOpen"></div>
          							<div id="online_tel_icon" class="online_icon">
            										<span class="pic"><img src="images/online_tel.png" /></span>
            										<span class="name">&#30005;&#35805;&#30452;&#21628;</span>
          							</div>
          							<div id="online_qq_icon" class="online_icon">
            										<span class="pic"><img src="images/online_qq.png" /></span>
            										<span class="name">&#22312;&#32447;&#23458;&#26381;</span>
          							</div>
          							<div id="online_message_icon" class="online_icon">
            										<span class="pic"><img src="images/online_message.png" /></span>
            										<span class="name">&#22312;&#32447;&#30041;&#35328;</span>
          							</div>
          							<div id="online_email_icon" class="online_icon">
            										<span class="pic"><a href="mailto:1234567@qq.com">
            											<img src="images/online_email.png" /></a>
            										</span>
            										<span class="name">&#21457;&#36865;&#37038;&#20214;</span>
          							</div>
                    				<div id="online_address_icon" class="online_icon">
            										<span class="pic">
            											<a href="http://sc.chinaz.com/"><img src="images/online_address.png" /></a>
            										</span>
            										<span class="name">&#20225;&#19994;&#22320;&#26631;</span>
          							</div>
                    				<div id="onlineTelTab" class="online_tab">
            							<div class="online_boxs">
            								<div class="boxs_t">
            									<span class="boxs_t_l"></span>
            									<span class="boxs_t_m"></span>
            									<span class="boxs_t_r"></span>
            								</div>
              								<div class="boxs_m_l">
                								<div class="boxs_m_r">
                  									<div class="box_m_m">
                    									<div id="onlineTel" class="online_tab_c">
                    										<small class="sanjiao"></small>
                    										<small class="tab_close"></small>
                      										<dl>
                        									<dt><strong>&#32852;&#31995;&#25105;&#20204;：</strong></dt>
                        									<dd><strong>&#32852;&#31995;&#20154;：</strong><span>王宝强</span></dd>                                                <dd><strong>&#30005;&#35805;：</strong><span>13000130005</span></dd>                                                                      
                        									</dl>
                    									</div>
                  									</div>
                								</div>
              								</div>
            								<div class="boxs_b">
            									<span class="boxs_b_l"></span>
            									<span class="boxs_b_m"></span>
            									<span class="boxs_b_r"></span>
            								</div>
            							</div>
          							</div>
          							<div id="onlineQQTab" class="online_tab">
            							<div class="online_boxs">
            								<div class="boxs_t">
            									<span class="boxs_t_l"></span>
            									<span class="boxs_t_m"></span>
            									<span class="boxs_t_r"></span>
            								</div>
              								<div class="boxs_m_l">
                								<div class="boxs_m_r">
                  									<div class="box_m_m">
                    									<div id="onlineQQ" class="online_tab_c">
                    										<small class="sanjiao"></small>
                    										<small class="tab_close"></small>
                    										<dl>
                                                                <dt>经理 </dt>
                                                                 <dd>
                                								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1234567&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:1234567:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>
                                								</dd>
                                                                <dd>
                                								<a target="_blank" href="http://wpa.qq.com/msgrd?v=3&uin=1234567&site=qq&menu=yes"><img border="0" src="http://wpa.qq.com/pa?p=2:1234567:51" alt="点击这里给我发消息" title="点击这里给我发消息"/></a>
                                								</dd>
                              								</dl>
                    									</div>
                  									</div>
                								</div>
              								</div>
            								<div class="boxs_b">
            									<span class="boxs_b_l"></span>
            									<span class="boxs_b_m"></span>
            									<span class="boxs_b_r"></span>
            								</div>
            						</div>
          							</div>
          							<div id="onlineMessageTab" class="online_tab">
            							<div class="online_boxs">
            								<div class="boxs_t">
            									<span class="boxs_t_l"></span>
            									<span class="boxs_t_m"></span>
            									<span class="boxs_t_r"></span>
            								</div>
              								<div class="boxs_m_l">
                								<div class="boxs_m_r">
                  									<div class="box_m_m">
                    									<div id="onlineMessage" class="online_tab_c">
                    										<small class="sanjiao"></small>
                    										<small class="tab_close"></small>
                      										<dl>
                        									<dt>
                        									<textarea onfocus="h_con()" onblur="s_con()" name="content2" id="content2" onkeyup="checkLen(this,200)"></textarea>
                        									</dt>
                        									<dd class="text_length">还可输入字符<b>200</b>（限制字符200）</dd>
                        									<dd><label>您的姓名：</label><input type="text" class="text_input" name="name" id="name"  maxlength="20"/></dd>
                        								    <dd><label>您的邮箱：</label><input type="text" class="text_input" name="e_mail" id="e_mail" maxlength="50"/></dd>
                        									<dd><label>您的电话：</label><input type="text" class="text_input" name="tel" id="tel" maxlength="30"/><input type="button" class="submitBut" value="提交" onclick="sub_check(446632)" /></dd>
                      										</dl>
                    									</div>
                  									</div>
                								</div>
              								</div>
            								<div class="boxs_b">
            									<span class="boxs_b_l"></span>
            									<span class="boxs_b_m"></span>
            									<span class="boxs_b_r"></span>
            								</div>
            							</div>
          							</div>
        						</div>
      						</div>
   						</div>
  					</div>
					<div class="boxs_b">
						<span class="boxs_b_l"></span>
						<span class="boxs_b_m"></span>
						<span class="boxs_b_r"></span>
					</div>	
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

