<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<script type="text/javascript" src="/MUMScrum/resource/js/userStories.js"></script>

<div class="crudLinks">
	<security:authorize access="hasRole('ScrumMaster')">
		<a href="<spring:url value="/userStories/add"/>">Add User Story</a>
	</security:authorize>
</div>

<c:forEach items="${userStories}" var="userStory">
	<div class="item">
		<div class="thumbnail">
			<div class="caption">
				<h3>${userStory.name}</h3>

				<p>Developer Estimate: ${userStory.devEstimate}</p>
				<p>Tester Estimate: ${userStory.testerEstimate}</p>

				<p>

					<a class="btn"
						href="<spring:url value="/userStories/edit/${userStory.id}"/>">Edit</a>

					<security:authorize access="hasRole('ScrumMaster')">
						<a class="btn deleteUserStory" deleteUrl="<spring:url value="/userStories/delete/${userStory.id}"/>">Delete</a>
					</security:authorize>
				</p>

			</div>
		</div>
	</div>
</c:forEach>
