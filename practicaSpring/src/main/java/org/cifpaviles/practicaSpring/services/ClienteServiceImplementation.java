package org.cifpaviles.practicaSpring.services;

import java.util.List;
import java.util.Optional;

import org.cifpaviles.practicaSpring.entities.Cliente;
import org.cifpaviles.practicaSpring.repositories.ClienteRepository;

public class ClienteServiceImplementation implements ClienteService {
	
	private final ClienteRepository clienteRepo;
	
	public ClienteServiceImplementation (ClienteRepository clienteRepo) {
		this.clienteRepo = clienteRepo;
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clienteRepo.findAll();
	}

	@Override
	public void insert(Cliente cliente) {
		clienteRepo.save(cliente);
		
	}

	@Override
	public void delete(Cliente cliente) {
		clienteRepo.delete(cliente);
		
	}

	@Override
	public Optional<Cliente> findById(long id) {
		// TODO Auto-generated method stub
		return clienteRepo.findById(id);
	}

}
