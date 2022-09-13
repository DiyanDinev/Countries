package com.tasks.rest.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Names {
	
	@JsonProperty("common")
	private String common;
	@JsonProperty("official")
	private String official;
	
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	public String getOfficial() {
		return official;
	}
	public void setOfficial(String official) {
		this.official = official;
	}

	
	
}
