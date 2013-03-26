<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AccoType add</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/">Home</a> | <a href="${pageContext.request.contextPath }/accoType">AccoType</a>
<form:form modelAttribute="accoType">
	Type: <form:input path="type"/><br/>
	<hr/>
	BF: <form:checkbox path="bf"/>Lunch: <form:checkbox path="lunch"/>Dinner: <form:checkbox path="dinner"/>PF: <form:checkbox path="pf"/>
	<input type="submit"> 
</form:form>

</body>
</html>