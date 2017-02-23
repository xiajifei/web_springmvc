<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script src="script/jquery-1.9.1.min.js"></script>
  </head>
  
  <body>
  	<canvas id="myCanvas" width="1303" height="450" >  
	</canvas>  
	<button id="butt">提交按钮</button>
  	<div id="inp"></div> 
	<script type="text/javascript">
		var canvas=document.getElementById("myCanvas");  
		var cxt=canvas.getContext("2d");  
		cxt.strokeStyle = "red";
		cxt.lineWidth = 1;
		var img=new Image(); 
		//默认第一次画图，统计每一次画图的坐标数组
		img.src="/test/img/car.png"; 
		var array_paint = [];
		var all_point=[];
		var current_y = 0;
		var current_x = 0;
		//判断鼠标是否按下
		var m_down = false;
		img.onload = function () //确保图片已经加载完毕  
		{  
		    cxt.drawImage(img,0,0,1303,450);  
		}
	    canvas.onmousedown=function(event){
	    	m_down = true;
// 			console.log(canvas.offsetLeft);
// 			console.log(event.offsetX);
			current_x = event.offsetX;
			current_y = event.offsetY;
			array_paint.push([current_x,current_y]);
			paint();
            
	    }
	    //画图方法
	    function paint(){
	    	cxt.beginPath();
			cxt.moveTo(array_paint[0][0],array_paint[0][1]);
// 			console.log(array_paint);
			if(array_paint.length == 1){
				cxt.lineTo(array_paint[0][0] +1,array_paint[0][1] +1);
      		}else{
				var i =1; 
			for(i in array_paint){
				cxt.lineTo(array_paint[i][0],array_paint[i][1]);
				cxt.moveTo(array_paint[i][0],array_paint[i][1]);
			}

		}
			cxt.closePath();
			cxt.stroke();
	    }
	    
	    	canvas.onmousemove = function(event){
				if(m_down){
					current_x = event.offsetX;
					current_y = event.offsetY;
					array_paint.push([current_x,current_y]);
					paint();
				}
			}
			canvas.onmouseup = function(event){
				m_down = false;
// 				all_point+=array_paint+"#";
				all_point.push(array_paint);
// 				console.log(all_point);
				array_paint = [];
			}
		$(function(){
		    $("#butt").click(function(){
		    	var jsonString = JSON.stringify(all_point);
		    	$.ajax({
		    		  url:"CanvasCalculator",
			          data:{id:jsonString},
			          type:"post",
			          dataType:"json",
		        	  success:function(msg){
		        	  	
		        	  }
		    	})
		    })
		});	
// 	    canvas.addEventListener("onmousedown",touch, false);  
// 	    canvas.addEventListener("touchmove",touch, false);  
// 	    canvas.addEventListener("touchend",touch, false); 
// 	    function touch (event){  
// 	        var event = event || window.event;  
// 	        var oInp = document.getElementById("inp");  
// 	        switch(event.type){  
// 	            case "onmousedown": 
// 	          		var s = "touchstart clientX (" + event.touches[0].clientX + "," + event.touches[0].clientY + ")";
// 	               	s+="<br/>touchstart pageX (" + event.touches[0].pageX + "," + event.touches[0].pageY + ")";
// 	               	s+="<br/>touchstart screenX (" + event.touches[0].screenX + "," + event.touches[0].screenY + ")";
// 	               	oInp.innerHTML=s;
// 	                break;  
// 	            case "touchend":  
// 	            	var s = "touchend clientX (" + event.touches[0].clientX + "," + event.touches[0].clientY + ")";
// 	               	s+="<br/>touchend pageX (" + event.touches[0].pageX + "," + event.touches[0].pageY + ")";
// 	               	s+="<br/>touchend screenX (" + event.touches[0].screenX + "," + event.touches[0].screenY + ")";
// 	               	oInp.innerHTML=s;
// 	                break;  
// 	            case "touchmove":  
// 	                event.preventDefault();  
//                   	var s = "touchmove clientX (" + event.touches[0].clientX + "," + event.touches[0].clientY + ")";
// 	               	s+="<br/>touchmove pageX (" + event.touches[0].pageX + "," + event.touches[0].pageY + ")";
// 	               	s+="<br/>touchmove screenX (" + event.touches[0].screenX + "," + event.touches[0].screenY + ")";
// 	               	oInp.innerHTML=s;
// 	                break;  
// 	        }  
          
//    		} 
	</script>
  </body>
</html>
