package br.com.delivery.model;

public enum StatusPedido {
	
	ABERTO, 
	CONCLUIDO,
	CANCELADO;
	
	public static StatusPedido getStatusPedidoByString(String status) {
		if (status.equals("ABERTO")) {
			return ABERTO;	
		}
		
		else if(status.equals("CONCLUIDO")) {
			return CONCLUIDO;
		}
		
		return CANCELADO;
	}
}
