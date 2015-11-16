$(document).ready(function() {

	$(".viewSprints").click(function() {
		showSprints($(this).attr('releaseId'));
	});

});


function showSprints(releaseId){
	$.ajax({
		url : '/MUMScrum/releases/getSprints/' + releaseId,
		type : 'GET',
		dataType : 'text json',
		contentType : "application/json",
		success : function(response) {
			

			showSprintsDialog(chartData);
		},
		error : function(error) {

		}
	});
}