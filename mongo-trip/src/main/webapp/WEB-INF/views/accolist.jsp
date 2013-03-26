<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Acco list</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/">Home</a> | <a href="${pageContext.request.contextPath }/acco/add">Add</a>


<table style="border: 1px solid;">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>AccoType</th>
		<th>Location</th>
	</tr>
	<c:forEach items="${accos}" var="acco">
		<tr>
			<td>${acco.id }</td>
			<td>${acco.name }</td>
			<td>${acco.accoType.type }</td>
			<td>${acco.location.name }</td>
	</c:forEach>
</table>



</body>
</html>