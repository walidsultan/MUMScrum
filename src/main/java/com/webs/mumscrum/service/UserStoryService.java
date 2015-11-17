/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.service;

import com.webs.mumscrum.domain.UserStory;

import java.util.List;

/**
 *
 * @author 984627
 */
public interface UserStoryService {
    public UserStory getUserStoryById(Long id);
    public void saveUserStory(UserStory userStory);
    public List<UserStory> getAllUserStories();
    public List<UserStory> getUserStoriesByDeveloperId(Long id);
    public List<UserStory> getUserStoriesByTesterId(Long id);
    public void deleteUserStoryById(Long id);
}
