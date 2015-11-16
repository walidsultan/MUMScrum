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
	var chartWidth=800;
	var chartHeight= 400;
	
	$.blockUI({
		message : $('.chartContainer'),
		css : {
			border : 'none',
			top : ($(window).height()-chartHeight)/2,
			left: ($(window).width()-chartWidth)/2,
			width : chartWidth
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
		width : chartWidth,
		height : chartHeight,
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
