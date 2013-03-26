<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>   
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trip add</title>
</head>
<body>
<a href="${pageContext.request.contextPath }/">Home</a> | <a href="${pageContext.request.contextPath }/trip">Trip</a>
<div>
<form:form modelAttribute="itineraryDto">
	<c:forEach items="${itineraryDto.days }" var="day" varStatus="row" >
		<div>
			<span>${row.count}</span>
			<form:select path="locationIds[${row.index }]">
				<option>-select-</option>
				<c:forEach items="${locations }" var="location">
					<option value="${location.id }"> ${location.name } </option>
				</c:forEach>
			</form:select>
			<form:select path="days[${row.index }].accoType">
				<option>-select-</option>
				<c:forEach items="${accoTypes }" var="accoType">
					<option value="${accoType.type }"> ${accoType.type} </option>
				</c:forEach>
			</form:select>
			<form:textarea path="days[${row.index }].comment"/>
		</div>
	</c:forEach>
	<input type="submit"/>
</form:form>
</div>
</body>
</html>