package com.fun7.backend.controllers;

public class Service {

	private String multiplayer;
	private String user_support;
	private String ads;
	public Service() {}
	public Service(String a, String b, String c) {
		this.multiplayer = a;
		this.user_support = b;
		this.ads = c;
	}
	
	public String getMultiplayer() {
		return multiplayer;
	}
	public void setMultiplayer(String multiplayer) {
		this.multiplayer = multiplayer;
	}
	public String getUser_support() {
		return user_support;
	}
	public void setUser_support(String user_support) {
		this.user_support = user_support;
	}
	public String getAds() {
		return ads;
	}
	public void setAds(String ads) {
		this.ads = ads;
	}
}
