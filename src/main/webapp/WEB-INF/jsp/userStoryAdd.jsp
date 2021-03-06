<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript"
	src="/MUMScrum/resource/js/UserStoryAdd.js"></script>

<form:form modelAttribute="newUserStory" class="form-horizontal">
	<fieldset>
		<legend>Add New User Story</legend>

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="form-group">
			<label class="control-label col-lg-2" for="name">Name: </label>
			<div class="col-lg-10">
				<form:input id="name" path="name" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="DevEstimate">Developer
				Estimate: </label>
			<div class="col-lg-10">
				<form:input id="name" path="DevEstimate" type="text"
					class="form:input-large" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="TesterEstimate">Tester
				Estimate: </label>
			<div class="col-lg-10">
				<form:input id="name" path="TesterEstimate" type="text"
					class="form:input-large" />
			</div>
		</div>

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
				<input type="submit" id="btnAdd" class="btn btn-primary" value="Add" />
			</div>
		</div>

	</fieldset>
</form:form>