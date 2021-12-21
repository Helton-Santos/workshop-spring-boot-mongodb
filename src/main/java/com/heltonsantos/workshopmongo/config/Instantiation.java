package com.heltonsantos.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.heltonsantos.workshopmongo.domain.Post;
import com.heltonsantos.workshopmongo.domain.User;
import com.heltonsantos.workshopmongo.dto.AuthorDTO;
import com.heltonsantos.workshopmongo.repository.PostRepository;
import com.heltonsantos.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll(); // Irá limpar a Coleção no MongoDB / It'll clean the Collection on the MongoDB
		postRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Set off trip!", "I will travel to Toronto!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Good Morning", "Today I woke up happy!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1 , post2));
		
		maria.getPosts().addAll(Arrays.asList(post1 , post2));
		userRepository.save(maria);
		
	}

	
	
}
