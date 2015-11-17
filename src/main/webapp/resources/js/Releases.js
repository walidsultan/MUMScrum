$(document).ready(function() {

	$(".viewSprints").click(function() {
		showSprints($(this).attr('releaseId'));
	});

	$(".deleteRelease").click(function() {
		var r = window.confirm("Are you sure want to delete this Release?");

		if (r == true) {
			window.location.href = $(this).attr('deleteUrl');
		}
	});
});

function showSprints(releaseId) {
	$
			.ajax({
				url : '/MUMScrum/releases/getSprints/' + releaseId,
				type : 'GET',
				dataType : 'text json',
				contentType : "application/json",
				success : function(sprints) {
					$('.divSprintsList tr.sprint').remove();

					var table = '';
					for (i in sprints) {
						var startDate = new Date(
								parseInt(String(sprints[i].startDate)));
						var endDate = new Date(
								parseInt(String(sprints[i].endDate)));
						var sprint = '<a href="/MUMScrum/sprints/edit/'
								+ sprints[i].id + '">' + sprints[i].name
								+ '</a>'
						table += '<tr class="sprint"><td>' + sprint
								+ '</td><td>' + startDate.toDateString()
								+ '</td><td>' + endDate.toDateString()
								+ '</td></tr>';
					}
					$('.divSprintsList table').append(table);
					showSprintsDialog();
				},
				error : function(error) {

				}
			});
}

function showSprintsDialog() {
	var dialogueWidth = 500;
	var dialogueHeight = 300;
	$.blockUI({
		message : $('.divSprintsList'),
		css : {
			border : 'none',
			top : ($(window).height() - dialogueHeight) / 2,
			left : ($(window).width() - dialogueWidth) / 2,
			width : dialogueWidth,
			cursor : 'default'
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