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
<a href="${pageContext.request.contextPath }/">Home</a> | <a href="${pageContext.request.contextPath }/acco">Acco</a>
<form:form modelAttribute="accoReservationDto">
	Acco: <form:select path="accoReservation.acco.id">
				<option>-select-</option>
				<c:forEach items="${accos }" var="acco">
					<option value="${acco.id}">${acco.name}</option>
				</c:forEach>
	</form:select><br/>
	<c:forEach items="${accoReservationDto.eatings }" var="eating" varStatus="row">
		<div>
		${row.count}.
		<c:forEach items="${eatingTypes}" var="eatingType">
			${eatingType } : <form:checkbox path="eatings[${row.index }][${eatingType}]"/>
		</c:forEach>
		</div>
		
	
	</c:forEach>


	
	<input type="submit" />
	
</form:form>

</body>
</html>