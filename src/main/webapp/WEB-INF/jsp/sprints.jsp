<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="crudLinks">
<a href="<spring:url value="/sprints/add"/>">Add Sprint</a>
</div>

<c:forEach items="${sprints}" var="sprint">
	<div class="item">
		<div class="thumbnail">
			<div class="caption">
				<h3>${sprint.name}</h3>
				<p>Start Date: <fmt:formatDate value="${sprint.startDate}" var="formattedStartDate" 
                type="date" pattern="MM-dd-yyyy" />${formattedStartDate}</p>
				<p>End Date: <fmt:formatDate value="${sprint.endDate}" var="formattedEndDate" 
                type="date" pattern="MM-dd-yyyy" />${formattedEndDate}</p>
				<p>

					<input type="button" class="btn" id="${category.id}"
						value="Details" />
				</p>

			</div>
		</div>
	</div>
</c:forEach>
