package com.webs.mumscrum.serviceImpl;

import com.webs.mumscrum.domain.UserStory;
import com.webs.mumscrum.repository.UserStoryRepository;
import com.webs.mumscrum.service.UserStoryService;

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
public class UserStoryServiceImpl implements UserStoryService {

	@Autowired
	UserStoryRepository userStoryRepository;

	@Override
	public UserStory getUserStoryById(Long id) {
		return userStoryRepository.findOne(id);
	}

	@Override
	public void saveUserStory(UserStory userStory) {
		userStoryRepository.save(userStory);
	}

	@Override
	public List<UserStory> getAllUserStories() {
		return (List<UserStory>) userStoryRepository.findAll();
	}

	@Override
	public List<UserStory> getUserStoriesByDeveloperId(Long id) {
		return userStoryRepository.getUserStoriesByDeveloperId(id);
	}

	@Override
	public List<UserStory> getUserStoriesByTesterId(Long id) {
		return userStoryRepository.getUserStoriesByTesterId(id);
	}

}
