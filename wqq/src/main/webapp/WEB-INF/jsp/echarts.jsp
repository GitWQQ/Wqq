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
	<script language="javascript" src="js/online.js"></script>
	<script type="text/javascript" src="js/echarts/echarts.min.js"></script>
	<link href="css/online.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript">
		//基于准备好的dom,初始化echarts实例
	$(function(){
		var ctx="<%=basepath%>";
		var yArray=new Array();
		var yArray2=new Array();
		$.ajax({
			type:'GET',
			url:ctx+'/getEchartsList.shtml',
			data:{},
			timeout:5000,
			async:false,
			dataType:'json',
			success:function(datas){
				for(var i=0; i<datas.length;i++){
					var data=datas[i];	
					yArray.push(data.price);
					yArray2.push(data.num);
				}
			},
			error:function(){
				alert("请求错误");
			}
		})		
		// =============================================
		var $demo1=$("#demo1");// jquery对象
		var demo1=$demo1[0]; //DOM对象
		var myChart=echarts.init(demo1);
		//指定图表的配置项和数据
		var option={
			title:{
				text:'柱状图',
				/*subtext:'ECHARTS副标题' */
				
			},
			tooltip:{
				trigger:'axis'
			},
			legend:{
				 data:['销量','价格','性价比'],
				 align: 'right'
			},
			toolbox:{
				show:true,
				feature:{
					magicType:{show:true,type:['stack','tiled','line','bar']},
					dataView:{show:true,readOnly:false},
					saveAsImage:{show:true,pixelRation:2},
					restore:{show:true}
				}
			},
			tooltip:{
				trigger:'axis',
				axisPointer:{
					type:'cross',
					crossStyle:{
						color:'#999'
					}
				}
			},
			grid:{
				left:'3%',
				right:'4%',
				bottom:'3%',
				containLabel: true
			},
			xAxis:[{
				data:['衬衫',"裤子","卫衣","羽绒服","睡衣"],
				type:'category',
				silent:false,
				splitLine:{
					show:false
				},
				 axisPointer: {
		            type: 'shadow'
		         }
			}],
			yAxis:[{
				type:'value',
				name:'价格/件',
				axisLabel:{
					formatter:'{value} ￥/件'
				}
				
				
			}],
			series:[{
				color:['#3398DB'],
				name:'销量',
				type:'bar',
				data:yArray2,
				markPoint:{
					data:[
					     {type:'max',name:'最大值'},
					     {type:'min',name:'最小值'}
					]
				},
				markLine:{
					data:[
						{type:'average',name:'平均值'}
					
					]
				},
				animationDelay:function(idx){
					return idx*10+100;
				}
			},{
				color:['#808080'],
				name:'价格',
				type:'bar',
				data:yArray,
				markPoint:{
					data:[
						     {type:'max',name:'最大值'},
						     {type:'min',name:'最小值'}
						]
				},
				markLine:{
					data:[
							{type:'average',name:'平均值'}
						]
				},
				animationDelay:function(idx){ // 越往后的数据延迟越大
					return idx*10;
				}
			},{
				name:'性价比',
				type:'line',
				data:yArray,
			}],
			animationEasing: 'elasticOut',
			animationDelayUpdate: function (idx) {
			     return idx * 0;
			}
			
		}
		//使用刚指定的配置项和数据显示图表
		myChart.setOption(option);
	})
	</script>
	<script type="text/javascript">
		$(function(){
			var myechart=echarts.init($("#demo2")[0]);
			var option={
				title:{
					text:'折线图',
					subtext:'折线图'
				},
				legend:{
					data:['价格','销量'],
				},
				tooltip:{
					trigger:'axis'
				},
				toolbox:{
					feature:{
						magicType:{show:true,type:['stack','tiled','line','bar']},
						dataView:{show:true,readOnly:false},
						saveAsImage:{show:true,pixelRation:2},
						restore:{show:true}
					}
				},
				xAxis:{
					type:'category',
					data:['Mon','Tue','Wed','Thu','Fri','Sat','Sun']
				},
				yAxis:{
					type:'value'
				},
				series:[
					   {
						name:'价格',
						type:'line',
						data:[820,932,901,934,1024,1000,1300]			
					},{
						name:'销量',
						type:'line',
						data:[560,902,611,954,1000,1200,1100]
					}
				]
				
			}
			myechart.setOption(option);
		})
	</script>
	<script type="text/javascript">
		$(function(){
			var myechart=echarts.init($("#demo3")[0]);
			var option={
				title:{
					text:'饼图'
				}
			}
			myechart.setOption(option);
		})
	</script>
</head>
<body style="background:#CEDFF3">
	<div>
		<span style="font-size:30px;">【echarts】</span>
		<div id="demo1" style="width:700px;height:450px;"></div>
		<div id="demo2" style="width:700px;height:450px;"></div>
		<div id="demo3" style="width:700px;height:450px;"></div>
	</div>
</body>
</html>
	