<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>login</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/login.action">
name:<input name="username" type="text" /> <br>
password:<input name="password" type="password" /> <br>
<input type="submit" value="LOGIN"/>
</form>

</body>
</html>