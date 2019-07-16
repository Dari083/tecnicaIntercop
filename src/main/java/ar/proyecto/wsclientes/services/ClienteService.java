package ar.proyecto.wsclientes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.proyecto.wsclientes.entities.Cliente;
import ar.proyecto.wsclientes.entities.ClienteEstadistica;
import ar.proyecto.wsclientes.repositories.ClienteRepository;
import ar.proyecto.wsclientes.utils.ClienteUtils;

@Service
public class ClienteService implements ClienteServiceInterface {
	
	@Autowired
	ClienteRepository repository;

	@Override
	public Cliente save(Cliente usuario) {
		return repository.save(usuario);
	}

	@Override
	public List<Cliente> list() {
		return repository.findAll();
	}

	@Override
	public ClienteEstadistica kpi() {
		List<Cliente> list = repository.findAll();
		ClienteEstadistica reporte = new ClienteEstadistica();
		int edadPromedio = ClienteUtils.edadPromedio(list);
		reporte.setEdadPromedio(edadPromedio);
		double desviacion = ClienteUtils.desviacion(list);
		reporte.setDesviacionEstandar(desviacion);
		return reporte;
	}
	
	
	
	

}
