package com.fun7.backend.users;

public class Request {
	public String getTimezone() {
		return timezone;
	}

	public String getUserId() {
		return userId;
	}

	public String getCc() {
		return cc;
	}

	private String timezone;
	private String userId;
	private String cc;
	public Request(String timezone, String userId, String cc) {
		this.timezone = timezone;
		this.userId = userId;
		this.cc = cc;
	}
}