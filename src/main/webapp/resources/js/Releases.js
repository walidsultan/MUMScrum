$(document).ready(function() {

	$(".viewSprints").click(function() {
		showSprints($(this).attr('releaseId'));
	});

});

function showSprints(releaseId) {
	$.ajax({
		url : '/MUMScrum/releases/getSprints/' + releaseId,
		type : 'GET',
		dataType : 'text json',
		contentType : "application/json",
		success : function(sprints) {
			$('.divSprintsList tr.sprint').remove();

			var table='';
			for (i in sprints) {
				table+='<tr class="sprint"><td>'+sprints[i].name+'</td></tr>';		
			}
			showSprintsDialog();
		},
		error : function(error) {

		}
	});
}

function showSprintsDialog(){
	var dialogueWidth=500;
	var dialogueHeight=300;
	$.blockUI({
		message : $('.divSprintsList'),
		css : {
			border : 'none',
			top : ($(window).height()-dialogueHeight)/2,
			left: ($(window).width()-dialogueWidth)/2,
			width : dialogueWidth
		},
		onBlock : function() {
			$(".blockOverlay").on('click', function() {
				$.unblockUI();
			})
		},
		overlayCSS : {
			cursor : 'default'
		}

	});
}