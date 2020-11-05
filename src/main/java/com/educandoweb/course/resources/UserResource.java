package com.educandoweb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.User;

//****Essa classe é um recurso web implementado pelo controlador Web

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping // Anotação para indicar que é uma requisição do tipo get do HTTP
	public ResponseEntity<User> findAll() {
		User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
		return ResponseEntity.ok().body(u); // Retorna no HTTP. O "body" faz retornar a resposta
	}
}
