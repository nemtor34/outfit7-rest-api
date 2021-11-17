package com.fun7.backend.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class User {

  private @Id String userId;
  private String name;
  private String last_name;
  private String e_mail;
  private int experience;
  
  User(){};
  
  User(String userId, String name, String last_name, String e_mail) {
	  this.userId = userId;
	  this.name = name;
	  this.last_name = last_name;
	  this.e_mail = e_mail;
	  this.experience = 0;
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
