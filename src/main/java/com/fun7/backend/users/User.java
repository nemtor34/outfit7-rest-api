package com.fun7.backend.users;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

  private @Id String userId;
  private String name;
  private String last_name;
  private String e_mail;
  private int experience;
  
  public User(){};
  
  public User(String userId, String name, String last_name, String e_mail) {
	  this.userId = userId;
	  this.name = name;
	  this.last_name = last_name;
	  this.e_mail = e_mail;
	  this.experience = 0;
  }
  
  public boolean equals(User user) {
	  if (this.userId != user.getUserId()) {
		  return false;
	  }
	  if (this.name != user.getName()) {
		  return false;
	  }
	  if (this.last_name != user.getLast_name()) {
		  return false;
	  }
	  if (this.e_mail != user.getE_mail()) {
		  return false;
	  }
	  return true;
  }
  
  public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}
	
	public void addExperience() {
		this.experience = this.experience + 1;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
