/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.service;

import com.webs.mumscrum.domain.Sprint;
import java.util.List;

/**
 *
 * @author 984627
 */
public interface SprintService {
    public Sprint getSprintById(Long id);
    public void saveSprint(Sprint sprint);
    public List<Sprint> getAllSprints();
	public List<Sprint> getSprintsByReleaseId(Long releaseId);
	public void deleteSprintById(long id);
}
