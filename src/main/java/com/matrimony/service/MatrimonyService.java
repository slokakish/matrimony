package com.matrimony.service;

<<<<<<< HEAD
import java.util.Date;

import org.springframework.stereotype.Service;

=======
import org.springframework.stereotype.Service;

import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
>>>>>>> jyoti
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;

@Service
public interface MatrimonyService {

<<<<<<< HEAD
	Login createProfile(Profile profile);


	Login validateLogin(String userName, String password);
=======
	Login createProfile(ProfileDto profileDto);

	Login validateLogin(LoginDto loginDto);

	Profile getFilteredProfile(Integer profileId);
>>>>>>> jyoti

}
