package com.canesin.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canesin.workshopmongo.domain.User;
import com.canesin.workshopmongo.services.UserService;

@RestController // indica que sera o controlador
@RequestMapping(value = "/users") // url para invocar
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> lista = service.findAll();
		return ResponseEntity.ok()
							 .body(lista);
	}

}