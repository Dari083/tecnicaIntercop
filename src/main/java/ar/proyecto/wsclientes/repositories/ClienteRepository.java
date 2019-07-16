package ar.proyecto.wsclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.proyecto.wsclientes.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findByNombre(String nombre);
	
}
