package com.educandoweb.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.services.UserService;

//****Essa classe é um recurso web implementado pelo controlador Web

@RestController
@RequestMapping(value = "/users")
public class UserResource { //Controlador REST

// Dependência para o service
	@Autowired
	private UserService service; // Para isso funcionar, a classe tem que estar registrada como um componente do Spring
	
	@GetMapping // Anotação para indicar que é uma requisição do tipo get do HTTP
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // Retorna no HTTP. O "body" faz retornar a resposta
	}
	
	//Implementação para buscar um usuário por ID
	@GetMapping(value = "/{id}") // Passa na URL o valor da ID do usuário. Indica que a requisição aceita um ID dentro da URL
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //"Ok" indica que teve sucesso. Corpo da requisição "body", vai o "obj".
	}
	
	//Inserção de um novo usuário no BD
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build(); //retorna uma resposta vazia
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj); 
	}
}