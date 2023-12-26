package com.canesin.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canesin.workshopmongo.domain.User;
import com.canesin.workshopmongo.dto.UserDTO;
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

	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO(UserDTO dto) {
		return new User(dto.getId(), dto.getName(), dto.getEmail());
	}

	public void delete(String id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User update(User user) {
		User newUser = findById(user.getId());
		updateData(newUser, user);
		return repository.save(newUser);
	}
	
	public void updateData(User newUser, User oldUser) {
		newUser.setName(oldUser.getName());
		newUser.setEmail(oldUser.getEmail());
	}
}
