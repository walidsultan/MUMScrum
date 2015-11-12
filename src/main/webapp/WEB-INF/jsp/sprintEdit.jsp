<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
	
<script type="text/javascript" src="/MUMScrum/resource/js/SprintAdd.js"></script>

<form:form modelAttribute="existingSprint" class="form-horizontal">
	<fieldset>
		<legend>Edit Sprint</legend>

		<form:errors path="*" cssClass="alert alert-danger" element="div" />

		<div class="form-group">
			<label class="control-label col-lg-2" for="name">Name: </label>
			<div class="col-lg-10">
				<form:input id="name" path="name" type="text"
					class="form:input-large" />
			</div>
		</div>


		<div class="form-group">
			<label class="control-label col-lg-2" for="description">Start
				Date: </label>
			<div class="col-lg-10">
				<form:input id="startDate" path="startDate" rows="2" />
			</div>
		</div>

		<div class="form-group">
			<label class="control-label col-lg-2" for="description">End
				Date: </label>
			<div class="col-lg-10">
				<form:input id="endDate" path="endDate" rows="2" />
			</div>
		</div>

		<div class="form-group">
			<label for="release">Release:</label><br />

			<form:select id="release" path="scrumRelease.id">
				<form:option value="" label="Select Release"></form:option>
				<form:options items="${releases}" itemLabel="name" itemValue="id"></form:options>
			</form:select>
		</div>
	<div class="form-group">
			<label for="release">SCRUM Master:</label><br />

			<form:select id="scrumMaster" path="scrumMaster.id">
				<form:option value="0" label="Select SCRUM Master"></form:option>
				<c:forEach var="scrumMaster" items="${scrumMasters}">
					<form:option value="${scrumMaster.id}"
						label="${scrumMaster.firstName} ${scrumMaster.lastName}"></form:option>
				</c:forEach>

			</form:select>
		</div>

		<div class="form-group">
			<div class="col-lg-offset-2 col-lg-10">
				<input type="submit" id="btnAdd" class="btn btn-primary"
					value="Edit" />
			</div>
		</div>

	</fieldset>
</form:form>