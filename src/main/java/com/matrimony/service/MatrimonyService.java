package com.matrimony.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matrimony.dto.DashboardDto;
import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Dashboard;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;

@Service
public interface MatrimonyService {

	Login createProfile(ProfileDto profileDto);

	Login validateLogin(LoginDto loginDto);

	Profile getFilteredProfile(Integer profileId);

	Dashboard updateAcceptReject(DashboardDto profileDto);

	List<Dashboard> getInterestedProfiles(Integer profileId);

	List<Dashboard> getAcceptedProfiles(Integer profileId);

	List<Dashboard> getRejectedProfiles(Integer profileId);

}
