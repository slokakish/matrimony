package com.matrimony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;
import com.matrimony.repository.LoginRepository;
import com.matrimony.repository.ProfileRepository;

@Service
public class MatrimonyServiceImpl implements MatrimonyService {
	@Autowired
	ProfileRepository profileRepo;

	@Autowired
	private LoginRepository loginRepository;

	public Login createProfile(Profile profile) {

		Login login = new Login();
		login.setPassword(profile.getFirstName());
		login.setLoginName(profile.getFirstName().substring(0, 3) + profile.getLastName().substring(0, 3));
		login.setActionMessage("success");

		login.setProfile(profile);

		profileRepo.save(profile);
		loginRepository.save(login);

		return login;
	}

	@Override
	public Login validateLogin(String loginName, String password) {
		Login login = new Login();

		login = loginRepository.findByLoginNameAndPassword(loginName, password);
		if (login != null) {
			login.setActionMessage("success");
			return login;
		} else {
			Login login1 = new Login();
			login1.setLoginName(loginName);
			login1.setActionMessage(loginName + "is not a valid user");
			return login1;
		}
	}

}
