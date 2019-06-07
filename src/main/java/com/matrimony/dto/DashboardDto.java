package com.matrimony.dto;

public class DashboardDto {
	private Integer profileId;
	private String profileName;
	private Integer actionProfileId;
	private String actionProfileName;
	private String action;

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

	public Integer getActionProfileId() {
		return actionProfileId;
	}

	public void setActionProfileId(Integer actionProfileId) {
		this.actionProfileId = actionProfileId;
	}

	public String getActionProfileName() {
		return actionProfileName;
	}

	public void setActionProfileName(String actionProfileName) {
		this.actionProfileName = actionProfileName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "profileDto [profileId=" + profileId + ", profileName=" + profileName + ", actionProfileId="
				+ actionProfileId + ", actionProfileName=" + actionProfileName + ", action=" + action + "]";
	}

	public DashboardDto() {
	        super();
	        // TODO Auto-generated constructor stub
	    }
}
