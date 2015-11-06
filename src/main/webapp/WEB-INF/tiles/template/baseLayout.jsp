<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>
<tiles:insertAttribute name="heading" />

</head>

<body>

	<div class="container">
		<div class="header">
		<div>
		<img alt="logo" src="/MUMScrum/resource/images/logo.jpg" class="logo">
			<ul class="nav nav-pills pull-right">
				<tiles:insertAttribute name="navigation" />
			</ul>
			</div>
			<h3 class="mainTitle">MUM Scrum</h3>
			<security:authorize access="isAuthenticated()">
			<div class="username">
			Hello <security:authentication property="principal.username" />
			</div>
			</security:authorize>
		</div>

		<div class="mainContent">
			<tiles:insertAttribute name="body" />
		</div>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>
