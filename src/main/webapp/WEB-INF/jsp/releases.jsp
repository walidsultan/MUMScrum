<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="crudLinks">
<a href="<spring:url value="/releases/add"/>">Add Release</a>
</div>

<c:forEach items="${releases}" var="release">
	<div class="item">
		<div class="thumbnail">
			<div class="caption">
				<h3>${release.name}</h3>
				
				<p>

			<a class="btn"
						href="<spring:url value="/releases/edit/${release.id}"/>">Edit</a>
				</p>

			</div>
		</div>
	</div>
</c:forEach>
