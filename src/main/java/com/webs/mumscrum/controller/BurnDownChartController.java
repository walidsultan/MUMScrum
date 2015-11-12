package com.webs.mumscrum.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webs.mumscrum.domain.BurnDownChartDay;
import com.webs.mumscrum.domain.WorkLog;
import com.webs.mumscrum.service.WorkLogService;

@Controller
@RequestMapping("/BurnDownChart")
public class BurnDownChartController {

	@Autowired
	WorkLogService workLogService;

	@RequestMapping(value = { "/{sprintId}"}, method = RequestMethod.GET)
	public @ResponseBody List<BurnDownChartDay> generateBurnDownChart(@PathVariable("sprintId") Long sprintId) {

		List<BurnDownChartDay> burnDownChart = new ArrayList<>();

		List<WorkLog> sprintWorkLog = workLogService.getWorkLogsBySprintId(sprintId);

		for (WorkLog worklog : sprintWorkLog) {
			BurnDownChartDay chartDay = getBurnDownChartBySprintDay(burnDownChart, worklog.getSprintDay());

			if (chartDay == null) {
				chartDay = new BurnDownChartDay();
				burnDownChart.add(chartDay);
				chartDay.setSprintDay(worklog.getSprintDay());
			}
			Integer workLogRemainingEffort = worklog.getOriginalEstimate() - worklog.getActualHours();
			Integer chartDayRemainingEffort=chartDay.getRemainingEffort()==null?0:chartDay.getRemainingEffort();
			chartDay.setRemainingEffort( chartDayRemainingEffort+ workLogRemainingEffort);
		}

		return burnDownChart;
	}

	private BurnDownChartDay getBurnDownChartBySprintDay(List<BurnDownChartDay> burnDownChart, Integer sprintDay) {
		for (BurnDownChartDay chartDay : burnDownChart) {
			if (chartDay.getSprintDay().equals(sprintDay)) {
				return chartDay;
			}
		}
		return null;
	}
}
