package com.educandoweb.course.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//*Converter objetos para o modelo relacional

@Entity
public class User implements Serializable { // Quando você quer que os objetos sejam transformados em cadeia de bystes, para que possam trafegar na rede, ou gravados em arquivos...

	private static final long serialVersionUID = 1L; // Número de série padrão do Serializable

	@Id //Indica qual atributo vai ter a chave primária da tabela do banco de dados.
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Identifica que ela é autoincrementável no BD
	
	private Long id; // Id é a chave primária da tabela de banco de dados.
	private String name;
	private String email;
	private String phone;
	private String password;
	
	public User() {
	}

	public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
