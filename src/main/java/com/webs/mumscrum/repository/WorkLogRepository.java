/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.repository;
import com.webs.mumscrum.domain.WorkLog;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 984627
 */
@Repository
public interface WorkLogRepository  extends CrudRepository<WorkLog,Long>{

	@Query("select w from WorkLog w where w.sprint.id = ?1")
	public List<WorkLog> getWorkLogsBySprintId(Long sprintId);
	
	@Query("select w from WorkLog w where w.sprint.id = ?1 and w.userStory.id= ?2 and w.sprintDay=?3")
	public WorkLog getWorkLogBySprintIdAndSprintDay(Long sprintId,Long userStoryId, Integer sprintDay);

	@Modifying
	@Transactional
	@Query("delete from WorkLog w where w.userStory.id = ?1")
	public void deleteWorkLogByUserStoryId(Long userStoryId);

	@Modifying
	@Transactional
	@Query("delete from WorkLog w where w.sprint.id = ?1")
	public void deleteWorkLogBySprintId(Long sprintId);
}
