package ar.proyecto.wsclientes.services;

import java.util.List;

import ar.proyecto.wsclientes.entities.Cliente;
import ar.proyecto.wsclientes.entities.ClienteEstadistica;

public interface ClienteServiceInterface {
	
	public Cliente save(Cliente cliente);
	
	public List<Cliente> list();
	
	public ClienteEstadistica kpi();
	

}
