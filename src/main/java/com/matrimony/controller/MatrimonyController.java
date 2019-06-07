package com.matrimony.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Login;
import com.matrimony.entity.Profile;
import com.matrimony.service.MatrimonyService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MatrimonyController {

	@Autowired
	MatrimonyService matrimonyService;

	@PostMapping("/createProfile")
	public ResponseEntity<Login> createProfile(@RequestBody ProfileDto profileDto) {
		Login profileData = matrimonyService.createProfile(profileDto);

		return new ResponseEntity<Login>(profileData, HttpStatus.OK);
	}

	@PostMapping("/loginUser")    
	public ResponseEntity<Login> validateLogin(@RequestBody LoginDto loginDto) 
	{        Login login = matrimonyService.validateLogin(loginDto);        
	return new ResponseEntity<Login>(login, HttpStatus.OK);    }
	
	@GetMapping("/getFilteredProfile/{profileId}")
	public ResponseEntity<Profile> getFilteredProfile(@RequestBody Integer profileId) {
		//Login profileData = matrimonyService.getFilteredProfile(profile);
		Profile profileData = matrimonyService.getFilteredProfile(profileId);

		return new ResponseEntity<Profile>(profileData, HttpStatus.OK);
	}
	
}
