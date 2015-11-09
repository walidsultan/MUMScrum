<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="crudLinks">
<a href="<spring:url value="/userStories/add"/>">Add User Story</a>
</div>

<c:forEach items="${userStories}" var="userStory">
	<div class="item">
		<div class="thumbnail">
			<div class="caption">
				<h3>${userStory.name}</h3>
				
				<p>
					Developer Estimate:
					${userStory.devEstimate}
						</p>
					<p>
					Tester Estimate:
					${userStory.testerEstimate}
						</p>
				
				<p>

			<a class="btn"
						href="<spring:url value="/userStories/edit/${userStory.id}"/>">Edit</a>
				</p>

			</div>
		</div>
	</div>
</c:forEach>
