package com.matrimony.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======
import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
>>>>>>> jyoti
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

<<<<<<< HEAD
	public Login createProfile(Profile profile) {

		Login login = new Login();
		login.setPassword(profile.getFirstName());
		login.setLoginName(profile.getFirstName().substring(0, 3) + profile.getLastName().substring(0, 3));
		login.setActionMessage("success");

=======
	public Login createProfile(ProfileDto profileDto) {

		Profile profile = new Profile();
		profile.setAge(profileDto.getAgeDto());
		profile.setCaste(profileDto.getCasteDto());
		profile.setAge(profileDto.getAgeDto());
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
>>>>>>> jyoti
		login.setProfile(profile);

		profileRepo.save(profile);
		loginRepository.save(login);

		return login;
	}

	@Override
<<<<<<< HEAD
	public Login validateLogin(String loginName, String password) {
		Login login = new Login();

		login = loginRepository.findByLoginNameAndPassword(loginName, password);
=======
	public Login validateLogin(LoginDto loginDto) {
		Login login = new Login();
		login = loginRepository.findByLoginNameAndPassword(loginDto.getLoginName(), loginDto.getPassword());
>>>>>>> jyoti
		if (login != null) {
			login.setActionMessage("success");
			return login;
		} else {
			Login login1 = new Login();
<<<<<<< HEAD
			login1.setLoginName(loginName);
			login1.setActionMessage(loginName + "is not a valid user");
=======
			login1.setLoginName(loginDto.getLoginName());
			login1.setActionMessage(loginDto.getLoginName() + "is not a valid user");
>>>>>>> jyoti
			return login1;
		}
	}

<<<<<<< HEAD
=======
	@Override
	public Profile getFilteredProfile(Integer profileId) {

		return null;
	}

>>>>>>> jyoti
}
