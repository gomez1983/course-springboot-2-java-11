package com.educandoweb.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;

//**Avisa ao Spring que esta é uma classe específica para configuração
@Configuration

//** Configuração específica para o perfil de teste. O nome dela tem que ser o mesmo que foi escolhido no "profile"
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository; //Objeto dependência que acessa os dados

	@Override
	public void run(String... args) throws Exception { // Tudo o que for colocado dentro deste método será executado quando a aplicação for iniciada
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2)); // Salva os usuários no banco de dados.
	}
}