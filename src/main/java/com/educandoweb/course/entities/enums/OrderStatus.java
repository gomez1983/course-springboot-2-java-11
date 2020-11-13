package com.educandoweb.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);	
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	//***Método público para acessar o código
	public int getCode() {
		return code;
	}
	
	//***Método estático público para converter valor númerico para enumerado
	public static OrderStatus valueOf(int code) { //Passar um código e o método retorna orderStatus referente ao código
		for (OrderStatus value : OrderStatus.values()) { // Percorre todos os valores possíveis (que são os 5 valores acima)
			if (value.getCode() == code) { // E vai testar se o valor é igual ao código que está procurando
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}	
}
