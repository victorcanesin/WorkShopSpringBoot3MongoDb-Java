package com.canesin.workshopmongo.domain.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.canesin.workshopmongo.domain.Post;
import com.canesin.workshopmongo.domain.User;
import com.canesin.workshopmongo.repository.PostRepository;
import com.canesin.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Override
	public void run(String... args) throws Exception {
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		
		Post post1 = new Post(null,sdf.parse("27/12/2023"), "Partiu viagem", "Vou viagar para SP , flw!", alex);
		Post post2 = new Post(null,sdf.parse("02/12/2023"), "bom dia nao é na segunda", "segunda é um dia dificil!", alex);
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}

}
