package com.webs.mumscrum.serviceImpl;

import com.webs.mumscrum.domain.WorkLog;
import com.webs.mumscrum.repository.WorkLogRepository;
import com.webs.mumscrum.service.WorkLogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 984627
 */
@Service
@Transactional
public class WorkLogServiceImpl implements WorkLogService {

    @Autowired
    WorkLogRepository workLogRepository;

    @Override
    public WorkLog getWorkLogById(Long id) {
        return workLogRepository.findOne(id);
    }

    @Override
    public void saveWorkLog(WorkLog workLog) {
    	workLogRepository.save(workLog);
    }

    @Override
    public List<WorkLog> getAllWorkLogs() {
        return (List<WorkLog>) workLogRepository.findAll();
    }

	@Override
	public List<WorkLog> getWorkLogsBySprintId(Long sprintId) {
        return workLogRepository.getWorkLogsBySprintId(sprintId);
	}

	@Override
	public void deleteWorkLogByUserStorId(Long userStoryId) {
		workLogRepository.deleteWorkLogByUserStorId(userStoryId);
	}

	

}
