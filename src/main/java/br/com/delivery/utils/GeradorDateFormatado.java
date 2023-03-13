package br.com.delivery.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import br.com.delivery.exceptions.DataException;

public class GeradorDateFormatado{
	
	public static Date gerarDateFormatado(Integer dia, Integer mes, Integer ano) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		String dataString = sdf.format(Date.from(LocalDate.of(ano, mes, dia).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		
		Date data=null; 
		try {
			data = sdf.parse(dataString);
		}
		catch(ParseException e) {}
		
		return data;
		
	}
	
	public static Date gerarDateFormatado(String dataString) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Date data = null;
		try {
			data = sdf.parse(dataString);
		}
		catch(ParseException e) {
			throw new DataException("Erro! data informada está no formato incorreto");
		}
		
		
		return data;
	}

}
