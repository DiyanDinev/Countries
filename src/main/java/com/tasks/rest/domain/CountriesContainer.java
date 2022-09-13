package com.tasks.rest.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountriesContainer {

	@JsonProperty("name")
	private Names name;
	@JsonProperty("population")
	private Long population;
	@JsonProperty("languages")
	private Languages languages;
	@JsonProperty("continents")
	private List<Continents> continents;
	
	public Names getName() {
		return name;
	}
	public void setName(Names name) {
		this.name = name;
	}
	public Long getPopulation() {
		return population;
	}
	public void setPopulation(Long population) {
		this.population = population;
	}
	public Languages getLanguages() {
		return languages;
	}
	public void setLanguages(Languages languages) {
		this.languages = languages;
	}
	public List<Continents>  getContinents() {
		return continents;
	}
	public void setContinents(List<Continents>  continents) {
		this.continents = continents;
	}
	
	
	

	
}
