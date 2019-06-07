package com.matrimony.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Dashboard implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer dashboardId;
	private Integer profileId;
	private String profileName;
	private Integer interestedProfileId;
	private String interestedProfileName;
	private Integer acceptedProfileID;
	private String acceptedProfileName;
	private Integer rejectedProfileId;
	private String rejectedProfileName;
	public Integer getDashboardId() {
		return dashboardId;
	}
	public void setDashboardId(Integer dashboardId) {
		this.dashboardId = dashboardId;
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
	public Integer getInterestedProfileId() {
		return interestedProfileId;
	}
	public void setInterestedProfileId(Integer interestedProfileId) {
		this.interestedProfileId = interestedProfileId;
	}
	public String getInterestedProfileName() {
		return interestedProfileName;
	}
	public void setInterestedProfileName(String interestedProfileName) {
		this.interestedProfileName = interestedProfileName;
	}
	public Integer getAcceptedProfileID() {
		return acceptedProfileID;
	}
	public void setAcceptedProfileID(Integer acceptedProfileID) {
		this.acceptedProfileID = acceptedProfileID;
	}
	public String getAcceptedProfileName() {
		return acceptedProfileName;
	}
	public void setAcceptedProfileName(String acceptedProfileName) {
		this.acceptedProfileName = acceptedProfileName;
	}
	public Integer getRejectedProfileId() {
		return rejectedProfileId;
	}
	public void setRejectedProfileId(Integer rejectedProfileId) {
		this.rejectedProfileId = rejectedProfileId;
	}
	public String getRejectedProfileName() {
		return rejectedProfileName;
	}
	public void setRejectedProfileName(String rejectedProfileName) {
		this.rejectedProfileName = rejectedProfileName;
	}
	@Override
	public String toString() {
		return "Dashboard [dashboardId=" + dashboardId + ", profileId=" + profileId + ", profileName=" + profileName
				+ ", interestedProfileId=" + interestedProfileId + ", interestedProfileName=" + interestedProfileName
				+ ", acceptedProfileID=" + acceptedProfileID + ", acceptedProfileName=" + acceptedProfileName
				+ ", rejectedProfileId=" + rejectedProfileId + ", rejectedProfileName=" + rejectedProfileName + "]";
	}
	public Dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}
}
