package com.webs.mumscrum.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class WorkLog {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private Sprint sprint;
	
	@OneToOne
	private UserStory userStory;
	
	private Integer sprintDay;
	
	private Integer ActualHours;
	
	private Integer OriginalEstimate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	public UserStory getUserStory() {
		return userStory;
	}

	public void setUserStory(UserStory userStory) {
		this.userStory = userStory;
	}

	public Integer getSprintDay() {
		return sprintDay;
	}

	public void setSprintDay(Integer sprintDay) {
		this.sprintDay = sprintDay;
	}

	public Integer getActualHours() {
		return ActualHours;
	}

	public void setActualHours(Integer actualHours) {
		ActualHours = actualHours;
	}

	public Integer getOriginalEstimate() {
		return OriginalEstimate;
	}

	public void setOriginalEstimate(Integer originalEstimate) {
		OriginalEstimate = originalEstimate;
	}
}
