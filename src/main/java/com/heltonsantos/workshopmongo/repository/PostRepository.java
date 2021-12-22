package com.heltonsantos.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.heltonsantos.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	// Essa declaração faz com que o SpringData monte a consulta / This declaration causes SpringData to assemble the query
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	
}
