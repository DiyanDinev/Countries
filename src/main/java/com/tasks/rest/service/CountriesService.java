package com.tasks.rest.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tasks.rest.domain.CountriesContainer;

@Service
public class CountriesService {

	
	public List<CountriesContainer> getCountries(String apiUrl) throws URISyntaxException{
			
			RestTemplate rt = new RestTemplate();
			URI uri = new URI(apiUrl);
			
			ResponseEntity<List<CountriesContainer>> responseEntity = rt.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<List<CountriesContainer>>() {});
			
			List<CountriesContainer> lc = responseEntity.getBody();
			
			return lc;
	}
}
