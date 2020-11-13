package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;

@Service // Anotação que registra a classe como um serviço (componente) do Spring
public class CategoryService { // Implementação para buscar todos os usuários e buscá-los por ID.
	
	@Autowired
	private CategoryRepository repository;
	
	//Método para retornar todos os usuários do banco de dados
	public List<Category> findAll (){
		return repository.findAll(); // Repassa a chamada para "repository.findAll"
	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get(); // Método retorna o objeto do tipo "Category" que estiver dentro do "Optional"
	}
}
