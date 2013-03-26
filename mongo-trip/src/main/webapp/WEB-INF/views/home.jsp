<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<ul>
	<li><a href="${pageContext.request.contextPath }/trip">Trip</a></li>
	<li><a href="${pageContext.request.contextPath }/location">Location</a></li>
	
	<li><a href="${pageContext.request.contextPath }/accoType">AccoType</a></li>
	<li><a href="${pageContext.request.contextPath }/acco">Acco</a></li>
</ul>
</body>
</html>
