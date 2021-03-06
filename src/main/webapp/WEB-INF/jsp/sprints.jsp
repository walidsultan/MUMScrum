<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<script type="text/javascript"
	src="/MUMScrum/resource/js/jquery.blockUI.js"></script>
	
<script type="text/javascript"
	src="/MUMScrum/resource/js/fusioncharts/fusioncharts.js"></script>
	
<script type="text/javascript"
	src="/MUMScrum/resource/js/fusioncharts/fusioncharts-jquery-plugin.min.js"></script>
	
<script type="text/javascript"
	src="/MUMScrum/resource/js/Sprints.js"></script>
	
<div class="crudLinks">
	<a href="<spring:url value="/sprints/add"/>">Add Sprint</a>
</div>

<c:forEach items="${sprints}" var="sprint">
	<div class="item">
		<div class="thumbnail">
			<div class="caption">
				<h3>${sprint.name}</h3>
				<p>
					Start Date:
					<fmt:formatDate value="${sprint.startDate}"
						var="formattedStartDate" type="date" pattern="MM-dd-yyyy" />${formattedStartDate}</p>
				<p>
					End Date:
					<fmt:formatDate value="${sprint.endDate}" var="formattedEndDate"
						type="date" pattern="MM-dd-yyyy" />${formattedEndDate}</p>

				<p>
					<a class="btn"
						href="<spring:url value="/sprints/edit/${sprint.id}"/>">Edit</a>
					<security:authorize access="hasRole('ScrumMaster')">
						<a class="btn viewBurnDownChart" sprintId="${sprint.id}">Burn Down</a>
						<a class="btn deleteSprint" deleteUrl="<spring:url value="/sprints/delete/${sprint.id}"/>">Del</a>
					</security:authorize>
				</p>
			</div>
		</div>
	</div>
</c:forEach>

<div class="chartContainer">
	
</div>
