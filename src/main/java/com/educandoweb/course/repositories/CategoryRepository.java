package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Category;

//***Instância do objeto "Repository" com várias operações para trabalhar com o usuário
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
