package com.example.myapplication.restCalls;


import com.google.gson.annotations.SerializedName;

public class Intervention {

	@SerializedName("id")
	private Integer id;
	

	private String title;
	

	private String description;
	

	private String type;
	

	private String status;

	private String client;

	private String dateIntervention;

	private String fullUserName;
	

	private User user;
	
	public Intervention() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getDateIntervention() {
		return dateIntervention;
	}

	public void setDateIntervention(String dateIntervention) {
		this.dateIntervention = dateIntervention;
	}

	public static Intervention createInstanceTest()
	{
		Intervention intervention = new Intervention();
		intervention.setTitle("int1");
		intervention.setDescription("desc");
		return intervention;
	}


	public String getFullUserName() {
		return fullUserName;
	}

	public void setFullUserName(String fullUserName) {
		this.fullUserName = fullUserName;
	}
}
