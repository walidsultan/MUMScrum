/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.webs.mumscrum.service;

import com.webs.mumscrum.domain.Release;
import java.util.List;

/**
 *
 * @author 984627
 */
public interface ReleaseService {
    public Release getReleaseById(Long id);
    public void saveRelease(Release release);
    public List<Release> getAllReleases();
	public void deleteReleaseById(long id);
}
