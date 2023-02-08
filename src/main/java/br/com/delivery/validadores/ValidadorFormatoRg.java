package br.com.delivery.validadores;


//50.375.482-1
// ponto no 2  e 6 e traço no 10 
//12 caracteres no total
public class ValidadorFormatoRg {
	
	public static Boolean validarFormatoRg(String rg) {
		
		String regexValidacao = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}[-][0-9]";
		
		if (rg.matches(regexValidacao)) {
			return true;
		}
		
		return false;
	}

}
