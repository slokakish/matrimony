package com.matrimony.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class ProfileDto {
	private Integer profileIdDto;
	private String firstNameDto;
	private String lastNameDto;
	private Integer ageDto;
	private String genderDto;
	private double salaryDto;
	private String casteDto;
	private String religionPreferenceDto;
	private String openToManyDto;
	private Long mobileDto;
	private String emailIdDto;
	@Temporal(TemporalType.DATE)
	private Date dobDto;
	public Integer getProfileIdDto() {
		return profileIdDto;
	}
	public void setProfileIdDto(Integer profileIdDto) {
		this.profileIdDto = profileIdDto;
	}
	public String getFirstNameDto() {
		return firstNameDto;
	}
	public void setFirstNameDto(String firstNameDto) {
		this.firstNameDto = firstNameDto;
	}
	public String getLastNameDto() {
		return lastNameDto;
	}
	public void setLastNameDto(String lastNameDto) {
		this.lastNameDto = lastNameDto;
	}
	public Integer getAgeDto() {
		return ageDto;
	}
	public void setAgeDto(Integer ageDto) {
		this.ageDto = ageDto;
	}
	public String getGenderDto() {
		return genderDto;
	}
	public void setGenderDto(String genderDto) {
		this.genderDto = genderDto;
	}
	public double getSalaryDto() {
		return salaryDto;
	}
	public void setSalaryDto(double salaryDto) {
		this.salaryDto = salaryDto;
	}
	public String getCasteDto() {
		return casteDto;
	}
	public void setCasteDto(String casteDto) {
		this.casteDto = casteDto;
	}
	public String getReligionPreferenceDto() {
		return religionPreferenceDto;
	}
	public void setReligionPreferenceDto(String religionPreferenceDto) {
		this.religionPreferenceDto = religionPreferenceDto;
	}
	public String getOpenToManyDto() {
		return openToManyDto;
	}
	public void setOpenToManyDto(String openToManyDto) {
		this.openToManyDto = openToManyDto;
	}
	public Long getMobileDto() {
		return mobileDto;
	}
	public void setMobileDto(Long mobileDto) {
		this.mobileDto = mobileDto;
	}
	public String getEmailIdDto() {
		return emailIdDto;
	}
	public void setEmailIdDto(String emailIdDto) {
		this.emailIdDto = emailIdDto;
	}
	public Date getDobDto() {
		return dobDto;
	}
	public void setDobDto(Date dobDto) {
		this.dobDto = dobDto;
	}
	@Override
	public String toString() {
		return "ProfileDto [profileIdDto=" + profileIdDto + ", firstNameDto=" + firstNameDto + ", lastNameDto="
				+ lastNameDto + ", ageDto=" + ageDto + ", genderDto=" + genderDto + ", salaryDto=" + salaryDto
				+ ", casteDto=" + casteDto + ", religionPreferenceDto=" + religionPreferenceDto + ", openToManyDto="
				+ openToManyDto + ", mobileDto=" + mobileDto + ", emailIdDto=" + emailIdDto + ", dobDto=" + dobDto
				+ "]";
	}
	public ProfileDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
