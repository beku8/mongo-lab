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
<form:form modelAttribute="acco">
	Name: <form:input path="name"/><br/>
<!-- 	AccoType: <select name="accoTypeType"> -->
<!-- 				<option>-select-</option> -->
<%-- 				<c:forEach items="${accoTypes }" var="accoType"> --%>
<%-- 					<option value="${accoType.type }">${accoType.type }</option> --%>
<%-- 				</c:forEach> --%>
<!-- 	</select><br/> -->
<!-- 	Location: <select name="locationId"> -->
<!-- 				<option>-select-</option> -->
<%-- 				<c:forEach items="${locations }" var="location"> --%>
<%-- 					<option value="${location.id }"> ${location.name } </option> --%>
<%-- 				</c:forEach> --%>
<!-- 	</select><br/> -->

	AccoType: <form:select path="accoType.type">
				<option>-select-</option>
				<c:forEach items="${accoTypes }" var="accoType">
					<option value="${accoType.type }">${accoType.type }</option>
				</c:forEach>
	</form:select><br/>
	Location: <form:select path="location.id">
				<option>-select-</option>
				<c:forEach items="${locations }" var="location">
					<option value="${location.id }"> ${location.name } </option>
				</c:forEach>
	</form:select><br/>


	
	<input type="submit" />
	
</form:form>

</body>
</html>