package com.educandoweb.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.exceptions.DatabaseException;
import com.educandoweb.course.services.exceptions.ResourceNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); // Método tenta dar o get. Se não tiver usuário ele tenta lançar a exceção.
	}
	
	public User insert(User obj) { //Operação retorna o usuário salvo
		return repository.save(obj); 
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id); // Vai instanciar o usuário sem ir ao BD. Apenas vai monitorar ele para poder trabalhar mais tarde no BD;
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());		
	}
	
}
