package com.canesin.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.canesin.workshopmongo.domain.User;

@RestController // indica que sera o controlador
@RequestMapping(value = "/users") // url para invocar
public class UserResource {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User maria = new User("1", "maria", "maria@gmail.com");
		User alex = new User("2", "alex", "alex@gmail.com");
		List<User> lista = new ArrayList<>();
		lista.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(lista);
	}

}