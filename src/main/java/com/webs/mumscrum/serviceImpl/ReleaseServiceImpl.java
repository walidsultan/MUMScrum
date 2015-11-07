package com.webs.mumscrum.serviceImpl;

import com.webs.mumscrum.domain.Release;
import com.webs.mumscrum.repository.ReleaseRepository;
import com.webs.mumscrum.service.ReleaseService;
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

    @Override
    public Release getReleaseById(Long id) {
        return releaseRepository.findOne(id);
    }

    @Override
    public void addRelease(Release release) {
    	releaseRepository.save(release);
    }

    @Override
    public List<Release> getAllReleases() {
        return (List<Release>) releaseRepository.findAll();
    }

	

}
