package br.com.delivery.validadores;

public class ValidadorFormatoCPF {
	
	public static Boolean validarFormatoCPF(String cpf) {
		
		String regexValidacao = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}";
		
		if (cpf.matches(regexValidacao)) {
			return true;
			
		}
		
		return false;
	}
	
	

}
