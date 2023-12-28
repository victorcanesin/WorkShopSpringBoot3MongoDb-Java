package com.canesin.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canesin.workshopmongo.domain.Post;
import com.canesin.workshopmongo.services.PostService;

@RestController // indica que sera o controlador
@RequestMapping(value = "/posts") // url para invocar
public class PostResource {

	@Autowired
	private PostService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {

		Post post = service.findById(id);

		return ResponseEntity.ok().body(post);
	}
}