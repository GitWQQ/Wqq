<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path=request.getContextPath();
	String basepath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/echarts/echarts.min.js"></script>
</head>
<body>
<!--为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <div id="main2" style="width:600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        
 		var val= [5, 20, 36, 10, 10, 20];
 		var price=[110,155,200,105,98,75];
        // 指定图表的配置项和数据
        var option = {
            title: {
                text: 'ECharts 入门示例'
            },
            tooltip: {},
            legend: {
                data:['销量']
            },
            xAxis: {
                data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
            },
            yAxis: {},
            series: [{
                name: '销量',
                type: 'bar',
                data:val
            }]
        };
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
        
        //--------------
        var myechart2=echarts.init(document.getElementById("main2"))
        var option2={
        	title:{
        		text:'ECHARTS',
        		subtext:'echarts'
        	},
        	tooltip:{trigger:'axis'},
        	legend:{data:['销量','价格']},
        	toolbox:{
        		show:true,feature:{mark:{show:true},dataView:{show:true,readOnly:false}}
        	},
        	xAxis:{
        		data:["衬衫",'羊毛衫','雪纺衫','裤子','高跟鞋','袜子']
        	},
        	yAxis:{type:'value'},
        	series:[
        	   {
        		name:'销量',
        		type:'bar',
        		data:val,
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
        		}
        	},{
        		name:'价格',
        		type:'bar',
        		data:price,
        		markPoint:{
        			data:[
        				{type:'max', name:'最高'},
        				{type:'min',name:'最低'}
        			]
        		},
        		markLine:{
        			data:[
        				{type:'average',name:'平均价格'}
        			]
        		}
        	}]
        };
        myechart2.setOption(option2);
    </script>
    <hr/>
    <div style="width:600px;height:400px;" id="line1">
    </div>
    <script type="text/javascript">
    	var myecharts2=echarts.init(document.getElementById("line1"));
    	var option3={
    		title:{
    			text:'Line',
    			subtext:'line'
    		},
    		legend:{data:["销量",'价格']},
    		tooltip:{trigger:'axis'},
    		xAxis:{
    			type:'category',
    			data:['Mon','Tue','Wed','Thu','Fri','Sat','Sun']
    		},
    		yAxis:{
    			type:'value',
    		},
    		series:[{
    			name:'销量',
    			type:'line',
    			data:[820,932,901,934,1290,1330,1320]
    		},{
    			name:'价格',
    			type:'line',
    			data:[8000,7999,7999,7800,7500,7500,7300]
    		}]
    	}
    	myecharts2.setOption(option3);
    </script>
    
</body>
</html>