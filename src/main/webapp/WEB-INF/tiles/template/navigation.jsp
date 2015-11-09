<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<li><a href="<spring:url value="/"/>"><spring:message
			code="navigation.home.label" /></a></li>
<li><a href="<spring:url value="/sprints/"/>"><spring:message
			code="navigation.sprints.label" /></a></li>
			
			<li><a href="<spring:url value="/releases/"/>"><spring:message
			code="navigation.releases.label" /></a></li>
			<li><a href="<spring:url value="/userStories/"/>"><spring:message
			code="navigation.userStories.label" /></a></li>
<security:authorize access="hasRole('admin')">
	
</security:authorize>

<security:authorize access="hasRole('admin')">
	
</security:authorize>

<security:authorize access="isAuthenticated()">
<li><a href="<spring:url value="/logout"/>"><spring:message
				code="navigation.logout.label" /></a></li>
</security:authorize>

<security:authorize access="isAnonymous()">
<li><a href="<spring:url value="/login"/>"><spring:message
				code="navigation.login.label" /></a></li>
</security:authorize>