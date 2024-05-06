package com.db.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="devperson")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String personId;
	private String firstName;
	private String lastName;
	private String dob;
	private String gender;
	private int age;
	private String email;
	private long phonno;
	private String education;
	private String occupation;
	private String maritalStatus;
	private String hobby;
	private String streetAddress;
	private String city;
	private int pincode;
	private String state;
	private String country;
	
	
	public Person(Long id, String personId, String firstName, String lastName, String dob, int birthYear, String gender,
			int age, String email, long phonno, String education, String occupation, String maritalStatus, String hobby,
			String plote, String streetAddress, String landmark, String city, int pincode, String state,
			String country) {
		super();
		this.id = id;
		this.personId = personId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phonno = phonno;
		this.education = education;
		this.occupation = occupation;
		this.maritalStatus = maritalStatus;
		this.hobby = hobby;
		this.streetAddress = streetAddress;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
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
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhonno() {
		return phonno;
	}
	public void setPhonno(long phonno) {
		this.phonno = phonno;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public Person() {
		super();
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", personId=" + personId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dob=" + dob + ", gender=" + gender + ", age=" + age + ", email="
				+ email + ", phonno=" + phonno + ", education=" + education + ", occupation=" + occupation
				+ ", maritalStatus=" + maritalStatus + ", hobby=" + hobby + ", streetAddress="
				+ streetAddress + " city=" + city + ", pincode=" + pincode + ", state="
				+ state + ", country=" + country + "]";
	}
	
}
