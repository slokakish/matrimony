package com.matrimony.service;

import org.springframework.stereotype.Service;

import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;

@Service
public interface MatrimonyService {

	Login createProfile(ProfileDto profileDto);

	Login validateLogin(LoginDto loginDto);

	Profile getFilteredProfile(Integer profileId);

}
