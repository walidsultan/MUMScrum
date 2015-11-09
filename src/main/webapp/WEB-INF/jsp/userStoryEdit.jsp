<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<script type="text/javascript"
	src="/MUMScrum/resource/js/UserStoryAdd.js"></script>

<form:form modelAttribute="existingUserStory" class="form-horizontal">
	<fieldset>
		<legend>Edit User Story</legend>

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