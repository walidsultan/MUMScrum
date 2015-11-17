/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.repository;
import com.webs.mumscrum.domain.Sprint;

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
public interface SprintRepository  extends CrudRepository<Sprint,Long>{

	@Query("select s from Sprint s where s.scrumRelease.id = ?1")
	List<Sprint> getSprintsByReleaseId(Long releaseId);

	@Modifying
	@Transactional
	@Query("delete from Sprint s where s.scrumRelease.id = ?1")
	void deleteSprintsByReleaseId(Long id);
}
