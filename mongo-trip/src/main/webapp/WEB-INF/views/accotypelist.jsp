<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AccoType list</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/">Home</a> | <a href="${pageContext.request.contextPath }/accoType/add">Add</a>


<table style="border: 1px solid;">
	<tr>
		<th>Type</th>
		<th>BF</th>
		<th>Lunch</th>
		<th>Dinner</th>
		<th>PF</th>
	</tr>
	<c:forEach items="${accoTypes}" var="accoType">
		<tr>
			<td>${accoType.type }</td>
			<td>${accoType.bf }</td>
			<td>${accoType.lunch }</td>
			<td>${accoType.dinner }</td>
			<td>${accoType.pf }</td>
	</c:forEach>
</table>



</body>
</html>