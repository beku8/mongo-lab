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
		<br/>
		Name: ${trip.name }<br/>
		Arrival date: ${trip.arrivalDate }<br/>
		Departure date: ${trip.departureDate }<br/>
	</div>
	<hr/>
	<c:choose>
		<c:when test="${not empty trip.itinerary}">
			<h3>Itinerary</h3>
			<c:forEach items="${trip.itinerary.days }" var="day">
				<div>
					<span>${day.day }. ${day.location.name } @ ${day.accoType }</span>
					
					<c:if test="${not empty day.comment}">
						(${day.comment })
					</c:if>
				</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<div> <a href="${pageContext.request.contextPath }/trip/addItinerary/${trip.id}">Add itinerary</a> </div>
		</c:otherwise>
	</c:choose>
	<c:if test="${not empty accoReservations }">
		<h3>Reservations</h3>
		<c:forEach items="${accoReservations }" var="accoReservation" varStatus="row">
		<div>
			${row.count }. ${accoReservation.inDate } to ${accoReservation.outDate } 
			${accoReservation.acco.name } @ ${accoReservation.location.name } 
			<ul>
				<c:forEach items="${accoReservation.eatings }" var="eating" varStatus="row2">
				<li>${row2.count }
					<c:forEach items="${accoReservation.acco.accoType.eatingTypes}" var="eatingType">
						 ${eatingType } : ${eating[eatingType]} 
					</c:forEach>
				</li>
				</c:forEach>
			</ul>
		</div>
		</c:forEach>
	</c:if>

</body>
</html>