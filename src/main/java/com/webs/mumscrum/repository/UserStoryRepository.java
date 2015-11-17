/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.repository;
import com.webs.mumscrum.domain.UserStory;

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
public interface UserStoryRepository  extends CrudRepository<UserStory,Long>{

	@Query("select u from UserStory u where u.developer.id = ?1")
	List<UserStory> getUserStoriesByDeveloperId(Long id);
	
	@Query("select u from UserStory u where u.tester.id = ?1")
	List<UserStory> getUserStoriesByTesterId(Long id);

	@Modifying
	@Transactional
	@Query("delete from UserStory u where u.sprint.id = ?1")
	void deleteUserStoriesBySprintId(Long id);
}
