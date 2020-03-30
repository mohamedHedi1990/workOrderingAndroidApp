package com.example.myapplication.restCalls;


import com.google.gson.annotations.SerializedName;

public class Invoice {

	@SerializedName("id")
	private Integer id;


	private String tasksDone;


	private String tasksNotDone;


	private String cost;


	private Intervention intervention;

	private User user;

	public Invoice() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTasksDone() {
		return tasksDone;
	}

	public void setTasksDone(String tasksDone) {
		this.tasksDone = tasksDone;
	}

	public String getTasksNotDone() {
		return tasksNotDone;
	}

	public void setTasksNotDone(String tasksNotDone) {
		this.tasksNotDone = tasksNotDone;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public Intervention getIntervention() {
		return intervention;
	}

	public void setIntervention(Intervention intervention) {
		this.intervention = intervention;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
