package com.matrimony.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer profileId;
	private String firstName;

	public Profile() {
		super();

	}

	private String lastName;
	private Integer age;
	private String gender;
	private double salary;
	private String caste;
	private String religionPreference;
	private String openToMany;
	private Long mobile;
	private String emailId;
	@Temporal(TemporalType.DATE)
	private Date dob;

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public String getReligionPreference() {
		return religionPreference;
	}

	public void setReligionPreference(String religionPreference) {
		this.religionPreference = religionPreference;
	}

	public String getOpenToMany() {
		return openToMany;
	}

	public void setOpenToMany(String openToMany) {
		this.openToMany = openToMany;
	}

	public Long getMobile() {
		return mobile;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + ", gender=" + gender + ", salary=" + salary + ", caste=" + caste + ", religionPreference="
				+ religionPreference + ", openToMany=" + openToMany + ", mobile=" + mobile + ", emailId=" + emailId
				+ ", dob=" + dob + "]";
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

}
