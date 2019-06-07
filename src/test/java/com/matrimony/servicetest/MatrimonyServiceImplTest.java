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

import com.matrimony.dto.DashboardDto;
import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Dashboard;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;
import com.matrimony.repository.DashboardRepository;
import com.matrimony.repository.LoginRepository;
import com.matrimony.repository.ProfileRepository;
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

	@Mock
	ProfileRepository profileRepository;

	static Dashboard dashboard = new Dashboard();
	static List<Dashboard> expectval = new ArrayList<Dashboard>();

	static ProfileDto ProfileDto = new ProfileDto();
	static Profile profile = new Profile();
	static Login login = new Login();
	static LoginDto loginDto = new LoginDto();

	static DashboardDto dashboardDto = new DashboardDto();
	static List<Profile> lst = new ArrayList<Profile>();

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

		ProfileDto.setAgeDto(12);
		ProfileDto.setCasteDto("asd");
		ProfileDto.setEmailIdDto("rohit@gmail");
		ProfileDto.setFirstNameDto("Rohit");
		ProfileDto.setGenderDto("M");
		ProfileDto.setLastNameDto("Kumar");
		ProfileDto.setMobileDto(122434L);
		ProfileDto.setReligionPreferenceDto("Hindu");
		ProfileDto.setSalaryDto(12340);

		profile.setAge(ProfileDto.getAgeDto());
		profile.setCaste(ProfileDto.getCasteDto());
		profile.setEmailId(ProfileDto.getEmailIdDto());
		profile.setFirstName(ProfileDto.getFirstNameDto());
		profile.setGender(ProfileDto.getGenderDto());
		profile.setLastName(ProfileDto.getLastNameDto());
		profile.setMobile(ProfileDto.getMobileDto());
		profile.setProfileId(111);
		profile.setReligionPreference(ProfileDto.getReligionPreferenceDto());
		profile.setSalary(ProfileDto.getSalaryDto());
		lst.add(profile);

		login.setPassword(ProfileDto.getFirstNameDto());
		login.setLoginName(ProfileDto.getFirstNameDto().substring(0, 3) + ProfileDto.getLastNameDto().substring(0, 3));
		login.setActionMessage("success");

		loginDto.setLoginName("RohKum");
		loginDto.setPassword("Rohit");

		dashboardDto.setProfileId(12);
		dashboardDto.setProfileName("Rohit");
		dashboardDto.setActionProfileId(31);
		dashboardDto.setActionProfileName("Ravi");
		dashboardDto.setAction("Sucess added");

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

	@Test
	public void testCreateProfile() {
		Login actval = matrimonyServiceImpl.createProfile(ProfileDto);
		Assert.assertEquals("RohKum", actval.getLoginName());

	}

	@Test
	public void testValidateLogin() {
		Mockito.when(loginRepository.findByLoginNameAndPassword("RohKum", "Rohit")).thenReturn(login);
		Login actval3 = matrimonyServiceImpl.validateLogin(loginDto);
		Assert.assertEquals("RohKum", actval3.getLoginName());
	}

	@Test
	public void testGetFilteredProfile() {
		Mockito.when(profileRepository.findByProfileId(profile.getProfileId())).thenReturn(profile);
		Mockito.when(profileRepository.findByGenderNotLike(profile.getGender())).thenReturn(lst);
		List<Profile> actval4 = matrimonyServiceImpl.getFilteredProfile(profile.getProfileId());
		Assert.assertEquals(lst.size(), actval4.size());
	}

}
