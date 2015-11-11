<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="crudLinks">
	<a href="<spring:url value="/hrSubsystem/Employees/add"/>">Add Employee</a>
</div>

<c:forEach items="${employees}" var="employee">
	<div class="item">
		<div class="thumbnail">
			<div class="caption">
				<h3>${employee.firstName} ${employee.lastName}</h3>
				<p>
				Role(s):
				<c:forEach items="${employee.roles}" var="role">
					${role.name}
				</c:forEach>
					</p>
				<p>
			
					</p>

				<p>
					<a class="btn"
						href="<spring:url value="/hrSubsystem/Employees/edit/${employee.id}"/>">Edit</a>
				</p>


			</div>
		</div>
	</div>
</c:forEach>
