package ar.proyecto.wsclientes.utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import ar.proyecto.wsclientes.entities.Cliente;

public class ClienteUtils {
	
	public static int calcularEdad(LocalDate fechaNacimiento) {
		
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNacimiento, ahora);
		return periodo.getYears();
	}
	
	public static int edadPromedio(List<Cliente> list) {
//		int edades = 0;
//		for(Usuario usu : list) {
//			edades+=calcularEdad(usu.getFechaNacmiento());
//		}
		int edades= list.stream()
			      .mapToInt(usu -> usu.getEdad())
			      .sum();
		return edades / list.size();
	}
	
	public static double desviacion(List<Cliente> list) {
		//Distancia a la media
		List<Double> listDist = new ArrayList<>();
		int promedio = edadPromedio(list);
		for(Cliente usu : list) {
			int valor1 = usu.getEdad() - promedio;
			double valor2 = Math.pow(valor1,2);
			listDist.add(valor2);
		}
		
		//Obtenemos ∑
		double sum = listDist.stream()
			      .mapToDouble(num -> num)
			      .sum();
		
		double div = sum / list.size();
		
		double res = Math.sqrt(div);
		
		return res;
	}

}
