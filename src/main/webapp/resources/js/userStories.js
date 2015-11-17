$(document).ready(function() {

	$(".deleteUserStory").click(function() {
		var r = window.confirm("Are you sure want to delete this User Story?");

		if (r == true) {
			window.location.href = $(this).attr('deleteUrl');
		}
	});

});
