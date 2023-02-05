package br.com.delivery.validadores;


//50.375.482-1
// ponto no 2  e 6 e traço no 10 
//12 caracteres no total
public class ValidadorFormatoRg {
	
	public static Boolean validarFormatoRg(String rg) {
		if (rg.length() == 12) {
			String[] caracteresRg = rg.split("(?!^)"); // regex para separar todos os caracteres do rg
			
			String rgSemPontoEtraco = "";
			if (caracteresRg[2].equals(".") && caracteresRg[6].equals(".") && caracteresRg[10].equals("-")) {
				
				for (int i = 0; i < 12; i++) {
					if(!caracteresRg[i].equals(".") && !caracteresRg[i].equals("-")) {
						rgSemPontoEtraco += caracteresRg[i]; }
				}
			}
			
			try {
				Long numerosRg = Long.valueOf(rgSemPontoEtraco);
				return true;
			}
			catch (NumberFormatException ex) {
				return false;
			}
		 
		}
		
		return false;
	}

}
