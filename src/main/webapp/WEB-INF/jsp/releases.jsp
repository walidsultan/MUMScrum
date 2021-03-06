<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript" src="/MUMScrum/resource/js/Releases.js"></script>

<script type="text/javascript"
	src="/MUMScrum/resource/js/jquery.blockUI.js"></script>
	
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
					<a class="btn viewSprints" releaseId="${release.id}">Sprints</a>
						<a class="btn deleteRelease" deleteUrl="<spring:url value="/releases/delete/${release.id}"/>">Delete</a>
				</p>

			</div>
		</div>
	</div>
</c:forEach>

<div class="divSprintsList hidden">
	<table>
		<tr>
			<td>Sprint Name</td>
			<td>Start Date</td>
			<td>End Date</td>
		</tr>
	</table>
</div>
