package com.matrimony.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DashboardInterest {
	@Id
	@GeneratedValue
	private Integer dashboardInterestId;
	private Integer profileId;
	private String profileName;
	private Integer interestProfileId;
	private String interestProfileName;

	public DashboardInterest() {
		super();
	}

	public Integer getDashboardInterestId() {
		return dashboardInterestId;
	}

	public void setDashboardInterestId(Integer dashboardInterestId) {
		this.dashboardInterestId = dashboardInterestId;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Integer getInterestProfileId() {
		return interestProfileId;
	}

	public void setInterestProfileId(Integer interestProfileId) {
		this.interestProfileId = interestProfileId;
	}

	public String getInterestProfileName() {
		return interestProfileName;
	}

	public void setInterestProfileName(String interestProfileName) {
		this.interestProfileName = interestProfileName;
	}

	@Override
	public String toString() {
		return "DashboardInterest [dashboardInterestId=" + dashboardInterestId + ", profileId=" + profileId
				+ ", profileName=" + profileName + ", interestProfileId=" + interestProfileId + ", interestProfileName="
				+ interestProfileName + "]";
	}

}
