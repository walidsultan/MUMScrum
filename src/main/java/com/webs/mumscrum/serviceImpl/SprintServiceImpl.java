package com.webs.mumscrum.serviceImpl;

import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.repository.SprintRepository;
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
public class SprintServiceImpl implements SprintService {

    @Autowired
    SprintRepository sprintRepository;

    @Override
    public Sprint getSprintById(Long id) {
        return sprintRepository.findOne(id);
    }

    @Override
    public void saveSprint(Sprint sprint) {
    	sprintRepository.save(sprint);
    }

    @Override
    public List<Sprint> getAllSprints() {
        return (List<Sprint>) sprintRepository.findAll();
    }

}
