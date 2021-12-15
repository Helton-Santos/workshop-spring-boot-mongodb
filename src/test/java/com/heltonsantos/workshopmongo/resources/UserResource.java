package com.heltonsantos.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.heltonsantos.workshopmongo.domain.User;
import com.heltonsantos.workshopmongo.services.UserService;

// Para indicar que é um Rest, usamos a anotação RestController
// To indicate that it is a Rest, we use the RestController annotation
@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;
	// Retornar lista de usuários
	// Return users list
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
