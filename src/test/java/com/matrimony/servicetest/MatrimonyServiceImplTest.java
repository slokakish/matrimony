package com.matrimony.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.matrimony.entity.Dashboard;
import com.matrimony.entity.Login;
import com.matrimony.repository.DashboardRepository;
import com.matrimony.repository.LoginRepository;
import com.matrimony.service.MatrimonyServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class MatrimonyServiceImplTest {

	@InjectMocks
	MatrimonyServiceImpl matrimonyServiceImpl;

	@Mock
	LoginRepository loginRepository;

	@Mock
	DashboardRepository dashboardRepository;

	static Dashboard dashboard = new Dashboard();
	static List<Dashboard> expectval = new ArrayList<Dashboard>();

	@BeforeClass
	public static void setUp() {
		dashboard.setDashboardId(11);
		dashboard.setAcceptedProfileID(1);
		dashboard.setAcceptedProfileName("qwe");
		dashboard.setInterestedProfileId(2);
		dashboard.setInterestedProfileName("asd");
		dashboard.setProfileId(3);
		dashboard.setProfileName("zxc");
		dashboard.setRejectedProfileId(4);
		dashboard.setRejectedProfileName("tyu");
		expectval.add(dashboard);
	}

	@Test
	public void testGetInterestedProfiles() {
		Mockito.when(dashboardRepository.getAllInterestedProfiles(dashboard.getInterestedProfileId()))
				.thenReturn(expectval);
		List<Dashboard> actval = matrimonyServiceImpl.getInterestedProfiles(dashboard.getInterestedProfileId());
		Assert.assertEquals(expectval.size(), actval.size());
	}

	@Test
	public void testGetAcceptedProfiles() {
		Mockito.when(dashboardRepository.getAllAccepetedProfiles(dashboard.getInterestedProfileId()))
				.thenReturn(expectval);
		List<Dashboard> actval = matrimonyServiceImpl.getAcceptedProfiles(dashboard.getInterestedProfileId());
		Assert.assertEquals(expectval.size(), actval.size());
	}

	@Test
	public void testGetRejectedProfiles() {
		Mockito.when(dashboardRepository.getAllRejectedProfiles(dashboard.getInterestedProfileId()))
				.thenReturn(expectval);
		List<Dashboard> actval = matrimonyServiceImpl.getRejectedProfiles(dashboard.getInterestedProfileId());
		Assert.assertEquals(expectval.size(), actval.size());
	}
}
