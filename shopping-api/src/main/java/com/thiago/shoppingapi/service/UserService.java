package com.thiago.shoppingapi.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.thiago.shoppingclient.dto.UserDTO;
import com.thiago.shoppingclient.exception.UserNotFoundException;

@Service
public class UserService {

	public UserDTO getUserByCpf(String cpf, String key) {
		try {
			RestTemplate restTemplate = new RestTemplate();		
			UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080/user/cpf/" + cpf);
		    builder.queryParam("key", key);
		    
			ResponseEntity<UserDTO> response = restTemplate.getForEntity(builder.toUriString(), UserDTO.class);			
			return response.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new UserNotFoundException();
		}
	}

}
