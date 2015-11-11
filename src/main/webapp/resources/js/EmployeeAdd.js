$(document).ready(function() {

	$("#dateOfBirth").datepicker();
	
	selectExistigRoles();
});

function selectExistigRoles(){
	$('.selectedRoles input').each(function(){
		$('input[name="roles"][value="'+$(this).val()+'"]').prop( "checked", true );
	});
}

