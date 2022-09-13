package com.tasks.rest.controller;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.rest.domain.CountriesContainer;
import com.tasks.rest.service.CountriesService;

@RestController
public class IndexController {
	
	@Autowired
	private CountriesService countriesService;

	@RequestMapping("/GetCountries")
	List<CountriesContainer> getCountries() throws URISyntaxException {
		return countriesService.getCountries("https://restcountries.com/v3.1/all");
	}	
	
	@RequestMapping("/SortCountries")
	String returnSortedCountries()  throws URISyntaxException{
		List<CountriesContainer> l = countriesService.getCountries("https://restcountries.com/v3.1/all");
		List<CountriesContainer> sortEurope = new ArrayList<CountriesContainer>();
		List<CountriesContainer> sortAsia = new ArrayList<CountriesContainer>();
		List<CountriesContainer> sortOceania = new ArrayList<CountriesContainer>();
		List<CountriesContainer> sortNA = new ArrayList<CountriesContainer>();
		List<CountriesContainer> sortSA = new ArrayList<CountriesContainer>();
		List<CountriesContainer> sortAf = new ArrayList<CountriesContainer>();
		
		for(CountriesContainer c : l) {
			for(int i = 0; i < c.getContinents().size(); i++) {
				if(c.getContinents().get(i).getValue().equals("Asia")) {
					sortAsia.add(c);
				} else if(c.getContinents().get(i).getValue().equals("Europe")) {
					sortEurope.add(c);
				} else if(c.getContinents().get(i).getValue().equals("Oceania")) {
					sortOceania.add(c);
				} else if(c.getContinents().get(i).getValue().equals("North America")) {
					sortNA.add(c);
				} else if(c.getContinents().get(i).getValue().equals("South America")) {
					sortSA.add(c);
				} else if(c.getContinents().get(i).getValue().equals("Africa")) {
					sortAf.add(c);
				}
			}
		}
		
		sortEurope = sortEurope.stream().sorted(Comparator.comparing(CountriesContainer::getPopulation)).collect(Collectors.toList());
		sortAsia = sortAsia.stream().sorted(Comparator.comparing(CountriesContainer::getPopulation)).collect(Collectors.toList());
		sortOceania = sortOceania.stream().sorted(Comparator.comparing(CountriesContainer::getPopulation)).collect(Collectors.toList());
		sortNA = sortNA.stream().sorted(Comparator.comparing(CountriesContainer::getPopulation)).collect(Collectors.toList());
		sortSA = sortSA.stream().sorted(Comparator.comparing(CountriesContainer::getPopulation)).collect(Collectors.toList());
		sortAf = sortAf.stream().sorted(Comparator.comparing(CountriesContainer::getPopulation)).collect(Collectors.toList());
		
		List<String> listEurope = new ArrayList<String>();
		List<String> listAsia = new ArrayList<String>();	
		List<String> listOceania = new ArrayList<String>();		
		List<String> listNA = new ArrayList<String>();
		List<String> listSA = new ArrayList<String>();
		List<String> listAfrica = new ArrayList<String>();
		
		for(CountriesContainer c: sortEurope) {
			if(c.getLanguages().getValue().size()<2) {
				sortEurope.remove(c);
			}
		}
		for(CountriesContainer c: sortAsia) {
			if(c.getLanguages().getValue().size()<2) {		
				sortAsia.remove(c);
			}
		}
		for(CountriesContainer c: sortOceania) {
			if(c.getLanguages().getValue().size()<2) {
				sortOceania.remove(c);
			}
		}
		for(CountriesContainer c: sortNA) {
			if(c.getLanguages().getValue().size()<2) {
				sortNA.remove(c);
			}
		}
		for(CountriesContainer c: sortSA) {
			if(c.getLanguages().getValue().size()<2) {
				sortSA.remove(c);
			}
		}
		for(CountriesContainer c: sortAf) {
			if(c.getLanguages().getValue().size()<2) {
				sortAf.remove(c);
			}
		}
		
		for(int i=0; i< 10 && i < sortEurope.size(); i++) {
			listEurope.add(sortEurope.get(i).getName().getOfficial());
		}
		for(int i=0; i< 10 && i < sortOceania.size(); i++) {
			listOceania.add(sortOceania.get(i).getName().getOfficial());
		}
		for(int i=0; i< 10 && i < sortAsia.size(); i++) {
			listAsia.add(sortAsia.get(i).getName().getOfficial());
		}
		for(int i=0; i< 10 && i < sortNA.size(); i++) {
			listNA.add(sortNA.get(i).getName().getOfficial());
		}
		for(int i=0; i< 10 && i < sortSA.size(); i++) {
			listSA.add(sortSA.get(i).getName().getOfficial());
		}
		for(int i=0; i< 10 && i < sortAf.size(); i++) {
			listAfrica.add(sortAf.get(i).getName().getOfficial());
		}
		
		return "Top 10 countries  by population with more than 2 languages are:    Europe " +  listEurope.toString() + 
																					" Asia " + listAsia.toString() +
																					" Oceania " + listOceania.toString() +
																					" North America " + listNA.toString() +
																					" South America " + listSA.toString() +
																					" Africa " + listAfrica.toString();

	}
	
}
