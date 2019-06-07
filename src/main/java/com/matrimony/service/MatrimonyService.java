package com.matrimony.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;

@Service
public interface MatrimonyService {

	Login createProfile(Profile profile);


	Login validateLogin(String userName, String password);

}
