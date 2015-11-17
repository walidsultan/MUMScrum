/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.service;

import java.util.List;

import com.webs.mumscrum.domain.WorkLog;

/**
 *
 * @author 984627
 */
public interface WorkLogService {
    public WorkLog getWorkLogById(Long id);
    public void saveWorkLog(WorkLog workLog);
    public List<WorkLog> getAllWorkLogs();
    public List<WorkLog> getWorkLogsBySprintId(Long sprintId);
    public void deleteWorkLogByUserStorId(Long userStoryId);
}
