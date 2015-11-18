package com.webs.mumscrum.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.domain.UserStory;
import com.webs.mumscrum.domain.WorkLog;
import com.webs.mumscrum.repository.SprintRepository;
import com.webs.mumscrum.repository.UserStoryRepository;
import com.webs.mumscrum.repository.WorkLogRepository;
import com.webs.mumscrum.service.UserStoryService;

/**
 *
 * @author 984627
 */
@Service
@Transactional
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	UserStoryRepository userStoryRepository;

	@Autowired
	WorkLogRepository workLogRepository;

	@Autowired
	SprintRepository sprintRepository;

	@Override
	public UserStory getUserStoryById(Long id) {
		return userStoryRepository.findOne(id);
	}

	@Override
	public void saveUserStory(UserStory userStory) {
		// Save work log changes
		Sprint sprint = userStory.getSprint();
		if (sprint != null) {
			sprint = sprintRepository.findOne(sprint.getId());

			Date todaysDate = Calendar.getInstance().getTime();

			if (sprint.getEndDate().after(todaysDate) && sprint.getStartDate().before(todaysDate)) {
				Long diff = Math.abs(sprint.getStartDate().getTime() - todaysDate.getTime());
				Integer diffDays = diff.intValue() / (24 * 60 * 60 * 1000);

				Integer actualHours = userStory.getDevActual() + userStory.getTesterActual();
				Integer originalEstimate = userStory.getDevEstimate() + userStory.getTesterEstimate();

				WorkLog worklog = workLogRepository.getWorkLogBySprintIdAndSprintDay(sprint.getId(), userStory.getId(),
						diffDays);

				if (worklog == null) {
					worklog = new WorkLog(actualHours, originalEstimate, diffDays, sprint, userStory);
				}
				else
				{
					worklog.setActualHours(actualHours);
					worklog.setOriginalEstimate(originalEstimate);
				}
				workLogRepository.save(worklog);
			}
		}
		// Save actual user story
		userStoryRepository.save(userStory);
	}

	@Override
	public List<UserStory> getAllUserStories() {
		return (List<UserStory>) userStoryRepository.findAll();
	}

	@Override
	public List<UserStory> getUserStoriesByDeveloperId(Long id) {
		return userStoryRepository.getUserStoriesByDeveloperId(id);
	}

	@Override
	public List<UserStory> getUserStoriesByTesterId(Long id) {
		return userStoryRepository.getUserStoriesByTesterId(id);
	}

	@Override
	public void deleteUserStoryById(Long id) {
		workLogRepository.deleteWorkLogByUserStoryId(id);
		userStoryRepository.delete(id);
	}

}

