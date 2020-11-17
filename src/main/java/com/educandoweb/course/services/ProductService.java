package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.ProductRepository;

@Service // Anotação que registra a classe como um serviço (componente) do Spring
public class ProductService { // Implementação para buscar todos os usuários e buscá-los por ID.
	
	@Autowired
	private ProductRepository repository;
	
	//Método para retornar todos os usuários do banco de dados
	public List<Product> findAll (){
		return repository.findAll(); // Repassa a chamada para "repository.findAll"
	}

	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get(); // Método retorna o objeto do tipo "Product" que estiver dentro do "Optional"
	}
}
