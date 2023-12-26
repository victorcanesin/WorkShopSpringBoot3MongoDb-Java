package com.canesin.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canesin.workshopmongo.domain.User;
import com.canesin.workshopmongo.dto.UserDTO;
import com.canesin.workshopmongo.services.UserService;

@RestController // indica que sera o controlador
@RequestMapping(value = "/users") // url para invocar
public class UserResource {
	
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		
		List<User> lista = service.findAll();
		List<UserDTO> listaDTO = lista.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		
		return ResponseEntity.ok()
							 .body(listaDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		
		User user = service.findById(id);		
		
		return ResponseEntity.ok()
							 .body(new UserDTO(user));
	}
	

}