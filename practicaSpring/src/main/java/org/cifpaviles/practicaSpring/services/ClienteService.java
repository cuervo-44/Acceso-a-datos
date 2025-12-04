package org.cifpaviles.practicaSpring.services;

import java.util.List;
import java.util.Optional;

import org.cifpaviles.practicaSpring.entities.Cliente;

public interface ClienteService {
	
	List<Cliente> findAll();
	void insert(Cliente cliente);
	void delete(Cliente cliente);
	public Optional<Cliente> findById(long id);

}
