package com.matrimony.service;

import org.springframework.stereotype.Service;

import com.matrimony.dto.LoginDto;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;

@Service
public interface MatrimonyService {

	Login createProfile(Profile profile);


	Login validateLogin(LoginDto loginDto);

}
