package com.heltonsantos.workshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.heltonsantos.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	@Query("{ 'title': <field>: { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	// Essa declaração faz com que o SpringData monte a consulta / This declaration causes SpringData to assemble the query
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ $and: [ {date: {$gte: ?1} }, { date: { $lte: ?2} } , ... , { $or: [ { 'title': <field>: { $regex: ?0, $options: 'i' } }, { 'body': <field>: { $regex: ?0, $options: 'i' } }, ... , { 'comments.text': <field>: { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
	
}
