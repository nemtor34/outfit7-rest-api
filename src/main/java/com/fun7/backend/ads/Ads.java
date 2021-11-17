package com.fun7.backend.ads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ads {
	
	private String ads;
	
	public Ads() {}
	
	public Ads(String ads) {
		this.ads = ads;
	}
	
	public String getAds() {
		return ads;
	}
	
	public void setAds(String ads) {
		this.ads = ads;
	}
	
	public String enabled() {
		if (this.ads != null) {
			if (this.ads.equals("sure, why not!")) {
				return ("enabled");
			}
		}
		return ("disabled");
	}

}