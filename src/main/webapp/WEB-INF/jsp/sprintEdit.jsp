<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<script type="text/javascript" src= "/MUMScrum/resource/js/SprintAdd.js"></script>

<form:form  modelAttribute="existingSprint" class="form-horizontal"  >
			<fieldset>
				<legend>Edit Sprint</legend>

				<form:errors path="*" cssClass="alert alert-danger" element="div"/>

				<div class="form-group">
					<label class="control-label col-lg-2" for="name">Name: </label>
					<div class="col-lg-10">
						<form:input id="name" path="name" type="text" class="form:input-large"/>
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Start Date: </label>
					<div class="col-lg-10">
						<form:input id="startDate" path="startDate" rows = "2"/>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="description">End Date: </label>
					<div class="col-lg-10">
						<form:input id="endDate" path="endDate" rows = "2"/>
					</div>
				</div>
				

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary" value ="Edit"/>
					</div>
				</div>
				
			</fieldset>
		</form:form>