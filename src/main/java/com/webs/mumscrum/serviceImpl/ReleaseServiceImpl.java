package com.webs.mumscrum.serviceImpl;

import com.webs.mumscrum.domain.Release;
import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.repository.ReleaseRepository;
import com.webs.mumscrum.repository.SprintRepository;
import com.webs.mumscrum.service.ReleaseService;
import com.webs.mumscrum.service.SprintService;

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
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ReleaseRepository releaseRepository;

    @Autowired
    SprintService sprintService;
    
    @Override
    public Release getReleaseById(Long id) {
        return releaseRepository.findOne(id);
    }

    @Override
    public void saveRelease(Release release) {
    	releaseRepository.save(release);
    }

    @Override
    public List<Release> getAllReleases() {
        return (List<Release>) releaseRepository.findAll();
    }

	@Override
	public void deleteReleaseById(long id) {
		List<Sprint> sprints= sprintService.getSprintsByReleaseId(id);
		for(Sprint sprint: sprints){
			sprintService.deleteSprintById(sprint.getId());
		}
		releaseRepository.delete(id);
	}

	

}
