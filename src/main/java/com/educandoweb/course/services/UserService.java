package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

@Service // Anotação que registra a classe como um serviço (componente) do Spring
public class UserService { // Implementação para buscar todos os usuários e buscá-los por ID.
	
	@Autowired
	private UserRepository repository;
	
	//Método para retornar todos os usuários do banco de dados
	public List<User> findAll (){
		return repository.findAll(); // Repassa a chamada para "repository.findAll"
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get(); // Método retorna o objeto do tipo "User" que estiver dentro do "Optional"
	}
	
	public User insert(User obj) { //Operação retorna o usuário salvo
		return repository.save(obj); 
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
