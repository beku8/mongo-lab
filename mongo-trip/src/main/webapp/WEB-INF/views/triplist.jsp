<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trip list</title>
</head>
<body>
<a href="trip/add">Add</a>
<table style="border: 1px solid;">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Arrival date</th>
		<th>Departure date</th>
	</tr>
	<c:forEach items="${trips}" var="trip">
		<tr>
			<td>${trip.id }</td>
			<td>${trip.name }</td>
			<td>${trip.arrivalDate }</td>
			<td>${trip.departureDate }</td>
		</tr>
	</c:forEach>
</table>



</body>
</html>