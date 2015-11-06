package com.webs.mumscrum.serviceImpl;

import com.webs.mumscrum.domain.Sprint;
import com.webs.mumscrum.respository.SprintRepository;
import com.webs.mumscrum.service.SprintService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 984627
 */
@Service
public class SprintServiceImpl implements SprintService {

    @Autowired
    SprintRepository sprintReposiotry;

    @Override
    public Sprint getServiceById(Long id) {
        return sprintReposiotry.findOne(id);
    }

    @Override
    public void addService(Sprint sprint) {
        sprintReposiotry.save(sprint);
    }

    @Override
    public List<Sprint> getAllServices() {
        return (List<Sprint>) sprintReposiotry.findAll();
    }

}
