<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Oops !!!</title>
</head>
<body>
	<p align="center" style ="color: red ; font-style: italic; font-size: 18px;"> Something went wrong. Please contact System Administrator</p>
	
	<p align="center"><a href="${pageContext.request.contextPath}/welcome" style="font-size: 16px; color: red; font-weight: bold">Lets go back!</a></p>
	
	<p align="center"><img alt="ImageIcon" style="height: 320px;width: 100%;" src="${pageContext.request.contextPath}/images/oops.jpg"></p>
</body>
</html>