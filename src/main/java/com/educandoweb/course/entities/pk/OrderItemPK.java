package com.educandoweb.course.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.Product;

//Esta é uma classe auxiliar, ela não rpecisa de construtores
@Embeddable
public class OrderItemPK implements Serializable { // Quando você quer que os objetos sejam transformados em cadeia de bystes, para que possam trafegar na rede, ou gravados em arquivos...

	private static final long serialVersionUID = 1L; // Número de série padrão do Serializable

	@ManyToOne
	@JoinColumn(name = "order_id") //Chave estrangeira na tabela do Banco de dados relacional
	private Order order;

	@ManyToOne
	@JoinColumn(name = "product_id") //Chave estrangeira na tabela do Banco de dados relacional
	private Product product;
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		OrderItemPK other = (OrderItemPK) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
}