package com.educandoweb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;

//****Essa classe é um recurso web implementado pelo controlador Web

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

// Dependência para o service
	@Autowired
	private OrderService service; // Para isso funcionar, a classe tem que estar registrada como um componente do Spring
	
	@GetMapping // Anotação para indicar que é uma requisição do tipo get do HTTP
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list); // Retorna no HTTP. O "body" faz retornar a resposta
	}
	
	//Implementação para buscar um usuário por ID
	@GetMapping(value = "/{id}") // Passa na URL o valor da ID do usuário. Indica que a requisição aceita um ID dentro da URL
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj); //"Ok" indica que teve sucesso. Corpo da requisição "body", vai o "obj".
	}
}