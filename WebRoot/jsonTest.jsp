<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>json交互测试</title>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-2.0.0.min.js"></script>
<script type="text/javascript">
function requestJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/requestJson.action',
		contentType:'application/json;charset=utf-8', //指定json格式
		data:'{"name":"清宝手机","price":9999}',
		success:function(data){
			alert(data);			
		}		
	});
}

function responseJson(){
	$.ajax({
		type:'post',
		url:'${pageContext.request.contextPath }/responseJson.action',
		//使用默认格式
		//contentType:'application/json;charset=utf-8', //指定json格式
		data:'name=清宝手机&price=9999',
		success:function(data){
			alert(data.name);	
		}		
	});
}
</script>
</head>
<body>

	<input type="button" onclick="requestJson()" value="请求json,输出json"/>
	<input type="button" onclick="responseJson()" value="请求key/value,输出json"/>
</body>
</html>