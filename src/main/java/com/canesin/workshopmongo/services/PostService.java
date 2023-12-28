package com.canesin.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canesin.workshopmongo.domain.Post;
import com.canesin.workshopmongo.repository.PostRepository;
import com.canesin.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public List<Post> findAll() {
		return repository.findAll();
	}

	public Post findById(String id) {
	
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
		// orElseThrow > vai tentar dar o get, se nao tiver usuario estoura a exception	
	}
}