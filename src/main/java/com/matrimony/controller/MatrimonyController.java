package com.matrimony.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matrimony.dto.DashboardDto;
import com.matrimony.dto.LoginDto;
import com.matrimony.dto.ProfileDto;
import com.matrimony.entity.Dashboard;
import com.matrimony.entity.DashboardInterest;
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

	@PostMapping("/login")
	public ResponseEntity<Login> validateLogin(@RequestBody LoginDto loginDto) {
		Login login = matrimonyService.validateLogin(loginDto);
		return new ResponseEntity<Login>(login, HttpStatus.OK);
	}

	@GetMapping("/getFilteredProfile/{profileId}")
    public ResponseEntity<List<Profile>> getFilteredProfile(@PathVariable Integer profileId) {

        List<Profile> profileData = new ArrayList<Profile>();
        profileData = matrimonyService.getFilteredProfile(profileId);

        return new ResponseEntity<List<Profile>>(profileData, HttpStatus.OK);
    }

	@GetMapping("/getInterestedProfile/{profileId}")
    public List<Dashboard> getInterestedProfile(@PathVariable Integer profileId){
        return matrimonyService.getInterestedProfiles(profileId);
        
    }
    
    @GetMapping("/getAcceptedProfile/{profileId}")
    public List<Dashboard> getAcceptedProfile(@PathVariable Integer profileId){
        return matrimonyService.getAcceptedProfiles(profileId);
        
    }
    
    @GetMapping("/getRejectedProfile/{profileId}")
    public List<Dashboard> getRejectedProfile(@PathVariable Integer profileId){
        return matrimonyService.getRejectedProfiles(profileId);
    }
    
    @PutMapping("/updateInterest")
    public ResponseEntity<Dashboard> updateInterest(@RequestBody DashboardDto dashboardDto) {
		Dashboard dashboard = matrimonyService.updateInterest(dashboardDto);
        return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
    }
    @PutMapping("/updateAcceptReject")
    public ResponseEntity<Dashboard> updateAcceptReject(@RequestBody DashboardDto profileDto) {
        Dashboard dashboard = matrimonyService.updateAcceptReject(profileDto);
        return new ResponseEntity<Dashboard>(dashboard, HttpStatus.OK);
    }
    @GetMapping("/getInterestedDashboardProfile")
    public List<DashboardInterest> getInterestedDashboardProfile() {
    	return matrimonyService.getInterestedDashboardProfile();
    }
}
