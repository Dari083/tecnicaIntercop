package ar.proyecto.wsclientes.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.proyecto.wsclientes.entities.Cliente;
import ar.proyecto.wsclientes.entities.ClienteEstadistica;
import ar.proyecto.wsclientes.services.ClienteServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API Clientes", description="Operaciones pertenecientes a Clientes")
@RestController
public class ClienteRestController {
	
	@Autowired
	ClienteServiceInterface clienteService;
	
	@ApiOperation(value = "Creacion de un nuevo Cliente", response = Cliente.class)
	@PostMapping(value = "/crearcliente")
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
		
	}
	
	@ApiOperation(value = "Lista de Clientes", response = List.class)
	@GetMapping(value = "/listclientes")
	public List<Cliente> list(@RequestBody Cliente cliente) {
		return clienteService.list();
		
	}
	
	@ApiOperation(value = "Estadística de Clientes", response = ClienteEstadistica.class)
	@GetMapping(value = "/kpiclientes")
	public ClienteEstadistica kpi(@RequestBody Cliente usuario) {
		return clienteService.kpi();
		
	}

}
