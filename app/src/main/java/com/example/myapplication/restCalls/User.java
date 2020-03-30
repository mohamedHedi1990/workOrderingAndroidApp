package com.example.myapplication.restCalls;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;




public class User {


	private Integer id;


	private String login;


	private String password;


	private String email;


	private String firstName;


	private String lastName;


	private String phoneNumber;


	private String team;


	private String teamLeader;


	private String actualFunction;
	
	// tester si l'utilisateur est un ingénieur de la société goodwill ou il est
	// client

	private Boolean isExternal;

	// tester si l'utilisateur est admin ou non (admin dans la société goodwill)

	private Boolean isAdmin;


	private Integer numberOfConnecions;
	

	private String uniqId;
	

	private String originalEstablishment;
	
	

	private String speciality;
	

	private String birthDate ;
	

	private String civilStatus ;
	

	private String streetAddress ;
	

	private String postalCode ;
	

    private List<Intervention> interventions ;

    private String client;
	
	public User() {}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getTeamLeader() {
		return teamLeader;
	}


	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader;
	}


	public String getActualFunction() {
		return actualFunction;
	}


	public void setActualFunction(String actualFunction) {
		this.actualFunction = actualFunction;
	}


	public Boolean getIsExternal() {
		return isExternal;
	}


	public void setIsExternal(Boolean isExternal) {
		this.isExternal = isExternal;
	}


	public Boolean getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public Integer getNumberOfConnecions() {
		return numberOfConnecions;
	}


	public void setNumberOfConnecions(Integer numberOfConnecions) {
		this.numberOfConnecions = numberOfConnecions;
	}


	public String getUniqId() {
		return uniqId;
	}


	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}


	public String getOriginalEstablishment() {
		return originalEstablishment;
	}


	public void setOriginalEstablishment(String originalEstablishment) {
		this.originalEstablishment = originalEstablishment;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}


	public String getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public String getCivilStatus() {
		return civilStatus;
	}


	public void setCivilStatus(String civilStatus) {
		this.civilStatus = civilStatus;
	}


	public String getStreetAddress() {
		return streetAddress;
	}


	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public List<Intervention> getInterventions() {
		return interventions;
	}


	public void setInterventions(List<Intervention> interventions) {
		this.interventions = interventions;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public static User createInstanceTest_admin()
{
	User user = new User();
	user.setLogin("admin");
	user.setPassword("test");
	user.setFirstName("mohamed");
	user.setLastName("hedi");
	user.setIsExternal(false);
	user.setIsAdmin(true);
	return user;
}
	public static User createInstanceTest_client()
	{
		User user = new User();
		user.setLogin("client");
		user.setPassword("test");
		user.setFirstName("mohamed");
		user.setLastName("hedi");
user.setClient("TT");
		user.setIsExternal(true);
		user.setIsAdmin(false);
		return user;
	}
	public static User createInstanceTest_normal()
	{
		User user = new User();
		user.setLogin("nesrine");
		user.setPassword("test123");
		user.setFirstName("nesrine");
		user.setLastName("riahi");
		user.setIsExternal(false);
		user.setIsAdmin(false);
		return user;
	}
	
	   
	   
}
