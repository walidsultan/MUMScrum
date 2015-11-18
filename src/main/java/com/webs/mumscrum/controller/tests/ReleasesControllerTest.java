package com.webs.mumscrum.controller.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.webs.mumscrum.domain.Release;
import com.webs.mumscrum.service.ReleaseService;

import org.junit.Assert;
import org.junit.FixMethodOrder;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/dispatcher-servlet.xml",
		"file:src/main/webapp/WEB-INF/applicationContext.xml", "file:src/main/webapp/WEB-INF/security-context.xml"

})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReleasesControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private ReleaseService releaseServiceMock;

	@Test
	public void addReleaseTest() {
		Release release = new Release();
		release.setName("Release Test");

		releaseServiceMock.saveRelease(release);

		List<Release> releases = releaseServiceMock.getAllReleases();

		Assert.assertTrue(releases.size() == 1);
		Assert.assertTrue(releases.get(0).getName().equals("Release Test"));
	}

	@Test
	public void editReleaseTest() {
		Release release = releaseServiceMock.getReleaseById(1L);
		Assert.assertTrue(release != null);
		release.setName("Release Test Edit");
		releaseServiceMock.saveRelease(release);

		release = releaseServiceMock.getReleaseById(1L);
		Assert.assertTrue(release.getName().equals("Release Test Edit"));
	}

	@Test
	public void removeReleaseTest() {
		releaseServiceMock.deleteReleaseById(1L);
		List<Release> releases = releaseServiceMock.getAllReleases();

		Assert.assertTrue(releases.size() == 0);
	}
}
