package com.tasks.rest.domain;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Languages {
	
	@JsonProperty("languages")
	private ArrayList<String> value;

	public ArrayList<String> getValue() {
		return value;
	}

	public void setValue(ArrayList<String> value) {
		this.value = value;
	}





	

}
