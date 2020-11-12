package com.educandoweb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.course.entities.Order;

//***Instância do objeto "Repository" com várias operações para trabalhar com o usuário
public interface OrderRepository extends JpaRepository<Order, Long>{

}
