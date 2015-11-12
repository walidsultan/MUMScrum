$(document).ready(function() {

	$(".viewBurnDownChart").click(function() {
		loadBurnDownChart($(this).attr('sprintId'));
	});

});

function loadBurnDownChart(sprintId) {
	$.ajax({
		url : '/MUMScrum/BurnDownChart/' + sprintId,
		type : 'GET',
		dataType : 'text json',
		contentType : "application/json",
		success : function(response) {
			var chartData = [];
			for (day in response) {
				chartData.push({
					'label' : 'Day ' + response[day].sprintDay,
					'value' : response[day].remainingEffort
				});
			}

			showBurnDownChart(chartData);
		},
		error : function(error) {

		}
	});
}

function showBurnDownChart(chartData) {
	$.blockUI({
		message : $('.chartContainer'),
		css : {
			border : 'none',
			top : '25%',
			left: '27%',
			width : "800"
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

	$('.chartContainer').insertFusionCharts({
		type : "column2d",
		width : "800",
		height : "400",
		dataFormat : "json",
		dataSource : {
			chart : {
				caption : "Sprint Burn Down Chart",
				subCaption : "",
				theme : "ocean"
			},
			data : chartData
		}

	});
}
