<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<form:form modelAttribute="existingUserStory" class="form-horizontal">
	<fieldset>
		<legend>Edit User Story</legend>

		<form:errors path="*" cssClass="alert alert-danger" element="div" />
		<security:authorize access="hasRole('ScrumMaster')"
			var="isScrumMaster" />
		<security:authorize access="hasRole('Developer')" var="isDeveloper" />
		<security:authorize access="hasRole('Tester')" var="isTester" />

		<div class="form-group">
			<label class="control-label col-lg-2" for="name">Name: </label>
			<div class="col-lg-10">
				<c:if test="${isScrumMaster }">
					<form:input id="name" path="name" type="text"
						class="form:input-large" />
				</c:if>
				<c:if test="${!isScrumMaster }">
					<div class="readonly">
						<c:out value="${existingUserStory.name}" />
						<form:input id="name" path="name" type="hidden"/>
					</div>
				</c:if>
			</div>
		</div>


		<div class="form-group">
			<label class="control-label col-lg-2" for="DevEstimate">Developer
				Estimate: </label>
			<div class="col-lg-10">
				<c:if test="${isScrumMaster || isDeveloper }">
					<form:input id="name" path="DevEstimate" type="text"
						class="form:input-large" />
				</c:if>
				<c:if test="${!isScrumMaster && !isDeveloper }">
					<div class="readonly">
						<c:out value="${existingUserStory.devEstimate}" />
						<form:input id="devEstimate" path="DevEstimate" type="hidden"/>
					</div>
				</c:if>

			</div>
		</div>

		<c:if test="${isDeveloper }">
			<div class="form-group">
				<label class="control-label col-lg-2" for="DevActual">Developer
					Actual: </label>
				<div class="col-lg-10">
					<form:input id="devActual" path="DevActual" type="text"
						class="form:input-large" />
				</div>
			</div>
		</c:if>

		<div class="form-group">
			<label class="control-label col-lg-2" for="TesterEstimate">Testing
				Estimate: </label>
			<div class="col-lg-10">
				<c:if test="${isScrumMaster || isTester }">
					<form:input id="testerEstimate" path="TesterEstimate" type="text"
						class="form:input-large" />
				</c:if>

				<c:if test="${!isScrumMaster && !isTester }">
					<div class="readonly">
						<c:out value="${existingUserStory.testerEstimate}" />
						<form:input id="testerEstimate" path="TesterEstimate" type="hidden"/>
					</div>
				</c:if>
			</div>
		</div>
		
		
		<c:if test="${isTester }">
			<div class="form-group">
				<label class="control-label col-lg-2" for="testActual">Testing
					Actual: </label>
				<div class="col-lg-10">
					<form:input id="testerActual" path="TesterActual" type="text"
						class="form:input-large" />
				</div>
			</div>
		</c:if>
		<c:if test="${isScrumMaster}">

			<div class="form-group">
				<label for="sprint">Sprint:</label><br />

				<form:select id="sprint_id" path="sprint.id">
					<form:option value="0" label="Select Sprint"></form:option>
					<form:options items="${sprints}" itemLabel="name" itemValue="id"></form:options>
				</form:select>
			</div>


			<div class="form-group">
				<label for="developer">Developer:</label><br />

				<form:select id="developer" path="developer.id">
					<form:option value="0" label="Select Developer"></form:option>
					<c:forEach var="developer" items="${developers}">
						<form:option value="${developer.id}"
							label="${developer.firstName} ${developer.lastName}"></form:option>
					</c:forEach>
				</form:select>
			</div>

			<div class="form-group">
				<label for="tester">Tester:</label><br />

				<form:select id="tester" path="tester.id">
					<form:option value="0" label="Select Tester"></form:option>
					<c:forEach var="tester" items="${testers}">
						<form:option value="${tester.id}"
							label="${tester.firstName} ${tester.lastName}"></form:option>
					</c:forEach>
				</form:select>
			</div>
		</c:if>

<c:if test="${!isScrumMaster}">
	<form:input id="sprint_id" path="sprint.id" type="hidden"/>
	<form:input id="developer_id" path="developer.id" type="hidden"/>
	<form:input id="tester" path="tester.id" type="hidden"/>
</c:if>
		<div class="form-group">
			<label class="control-label col-lg-2" for="Description">Description:
			</label>
			<div class="col-lg-10">
				<form:textarea id="name" path="Description" class="form:input-large"
					rows="4" cols="50" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Edit" />
			</div>
		</div>

	</fieldset>
</form:form>