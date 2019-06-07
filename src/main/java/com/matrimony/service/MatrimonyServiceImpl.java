package com.matrimony.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.dto.DashboardDto;
import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Dashboard;
import com.matrimony.entity.DashboardInterest;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;
import com.matrimony.repository.DashboardInterestRepository;
import com.matrimony.repository.DashboardRepository;
import com.matrimony.repository.LoginRepository;
import com.matrimony.repository.ProfileRepository;

@Service
public class MatrimonyServiceImpl implements MatrimonyService {
	@Autowired
	ProfileRepository profileRepo;

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private DashboardRepository dashboardRepository;

	@Autowired
	private DashboardInterestRepository dashboardInterestRepo;

	public Login createProfile(ProfileDto profileDto) {

		Profile profile = new Profile();
		profile.setAge(profileDto.getAgeDto());
		profile.setCaste(profileDto.getCasteDto());
		profile.setEmailId(profileDto.getEmailIdDto());
		profile.setDob(profileDto.getDobDto());
		profile.setFirstName(profileDto.getFirstNameDto());
		profile.setLastName(profileDto.getLastNameDto());
		profile.setGender(profileDto.getGenderDto());
		profile.setMobile(profileDto.getMobileDto());
		profile.setOpenToMany(profileDto.getOpenToManyDto());
		profile.setReligionPreference(profileDto.getReligionPreferenceDto());
		profile.setSalary(profileDto.getSalaryDto());

		Login login = new Login();
		login.setPassword(profileDto.getFirstNameDto());
		login.setLoginName(profileDto.getFirstNameDto().substring(0, 3) + profileDto.getLastNameDto().substring(0, 3));
		login.setActionMessage("success");

		// login.setProfile(profileDto);
		login.setProfile(profile);

		profileRepo.save(profile);
		loginRepository.save(login);

		return login;
	}

	public Login validateLogin(LoginDto loginDto) {
		Login login = new Login();
		login = loginRepository.findByLoginNameAndPassword(loginDto.getLoginName(), loginDto.getPassword());
		if (login != null) {
			login.setActionMessage("success");
			return login;
		} else {
			Login login1 = new Login();
			login1.setLoginName(loginDto.getLoginName());
			login1.setActionMessage(loginDto.getLoginName() + "is not a valid user");
			return login1;
		}
	}

	@Override
	public List<Dashboard> getInterestedProfiles(Integer profileId) {
		return dashboardRepository.getAllInterestedProfiles(profileId);
	}

	@Override
	public List<Dashboard> getAcceptedProfiles(Integer profileId) {
		return dashboardRepository.getAllAccepetedProfiles(profileId);
	}

	@Override
	public List<Dashboard> getRejectedProfiles(Integer profileId) {
		return dashboardRepository.getAllRejectedProfiles(profileId);
	}

	@Override
	public Dashboard updateAcceptReject(DashboardDto profileDto) {
		Dashboard newOrUpdated = null;
		Integer actionProfileID = profileDto.getActionProfileId();
		Integer profileId = profileDto.getProfileId();
		Dashboard actionProfile = dashboardRepository.findByProfileIdAndInterestedProfileId(actionProfileID, profileId);
		if (actionProfile != null) {
		if (profileDto.getAction().equalsIgnoreCase("Accept")) {
		actionProfile.setAcceptedProfileID(profileDto.getProfileId());
		actionProfile.setAcceptedProfileName(profileDto.getProfileName());
		actionProfile.setInterestedProfileId(null);
		actionProfile.setInterestedProfileName(null);
		actionProfile.setRejectedProfileId(null);
		actionProfile.setRejectedProfileName(null);
		} else if (profileDto.getAction().equalsIgnoreCase("Reject")) {
		actionProfile.setRejectedProfileId(profileDto.getProfileId());
		actionProfile.setRejectedProfileName(profileDto.getProfileName());
		actionProfile.setInterestedProfileId(null);
		actionProfile.setInterestedProfileName(null);
		actionProfile.setAcceptedProfileID(null);
		actionProfile.setAcceptedProfileName(null);
		} 
		newOrUpdated = dashboardRepository.save(actionProfile);
		}
		return newOrUpdated;
	}

	public Dashboard updateInterest(DashboardDto profileDto) {
		Dashboard newOrUpdated = null;
		Integer actionProfileID = profileDto.getActionProfileId();
		Integer profileId = profileDto.getProfileId();
		Dashboard actionProfile = dashboardRepository.findByProfileIdAndInterestedProfileId(actionProfileID, profileId);
		if (actionProfile == null) {
			Dashboard newProfile = new Dashboard();
			newProfile.setProfileId(profileDto.getActionProfileId());
			newProfile.setProfileName(profileDto.getActionProfileName());
			if (profileDto.getAction().equalsIgnoreCase("Interest")) {
			newProfile.setInterestedProfileId(profileDto.getProfileId());
			newProfile.setInterestedProfileName(profileDto.getProfileName());
			}
			DashboardInterest dbi = new DashboardInterest();
			dbi.setInterestProfileId(newProfile.getInterestedProfileId());
			dbi.setInterestProfileName(newProfile.getInterestedProfileName());
			dbi.setProfileId(newProfile.getProfileId());
			dbi.setProfileName(newProfile.getProfileName());
			dashboardInterestRepo.save(dbi);
			newOrUpdated = dashboardRepository.save(newProfile);
		}
		return newOrUpdated;
	}

	public List<Profile> getFilteredProfile(Integer profileId) {
		Profile profile = new Profile();
		List<Profile> lp = new ArrayList<Profile>();
		profile = profileRepo.findByProfileId(profileId);
		String profileGender = profile.getGender();
		List<Profile> profileList = profileRepo.findByGenderNotLike(profileGender);
		for (Profile pro : profileList) {
			Integer profId = pro.getProfileId();

			if (null != dashboardRepository.findByProfileDashId(profId)) {
				continue;
			} else {
				lp.add(pro);
			}

		}
		return lp;
	}

	public List<DashboardInterest> getInterestedDashboardProfile() {
		return dashboardInterestRepo.findAll();
	}
}
