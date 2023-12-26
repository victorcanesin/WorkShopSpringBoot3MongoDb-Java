package com.canesin.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canesin.workshopmongo.domain.User;
import com.canesin.workshopmongo.repository.UserRepository;
import com.canesin.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(String id) {
	
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
		// orElseThrow > vai tentar dar o get, se nao tiver usuario estoura a exception	
	}

}
