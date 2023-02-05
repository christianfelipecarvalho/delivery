package br.com.delivery.validadores;

public class ValidadorFormatoCPF {
	
	public static Boolean validarFormatoCPF(String cpf) {
		
		if (cpf.length() == 14) {
			String[] caracteresCPF = cpf.split("(?!^)"); //regex que separa todos os caracteres do cpf.
			
			String cpfSemPontoETraco = "";
			if (caracteresCPF[3].equals(".") && caracteresCPF[7].equals(".") && caracteresCPF[11].equals("-")) {
				for (int i = 0; i < 14; i ++) {
					if (!caracteresCPF[i].equals(".") && !caracteresCPF[i].equals("-")) {
						cpfSemPontoETraco += caracteresCPF[i];
					}
				}
			}
			
			try {  
				Long numerosCpf = Long.valueOf(cpfSemPontoETraco); //validação se os caracteres informados (com exceção dos pontos e do traço) são números
				return true;
			}
			catch (NumberFormatException ex) {
				return false;
			}
			
			
			
		}
		
		return false;
	}
	
	

}
