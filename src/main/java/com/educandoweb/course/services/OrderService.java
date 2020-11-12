package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.repositories.OrderRepository;

@Service // Anotação que registra a classe como um serviço (componente) do Spring
public class OrderService { // Implementação para buscar todos os usuários e buscá-los por ID.
	
	@Autowired
	private OrderRepository repository;
	
	//Método para retornar todos os usuários do banco de dados
	public List<Order> findAll (){
		return repository.findAll(); // Repassa a chamada para "repository.findAll"
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get(); // Método retorna o objeto do tipo "Order" que estiver dentro do "Optional"
	}
}
