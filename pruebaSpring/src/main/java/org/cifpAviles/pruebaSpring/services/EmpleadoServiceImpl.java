package org.cifpAviles.pruebaSpring.services;

import java.util.List;
import java.util.Optional;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.cifpAviles.pruebaSpring.repositories.EmpleadoRepository;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	private final EmpleadoRepository empleadoRepository;
	
	public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
		this.empleadoRepository=empleadoRepository;
	}

	@Override
	public List<Empleado> finAll() {
		// TODO Auto-generated method stub
		return empleadoRepository.findAll();
	}

	@Override
	public void insert(Empleado empleado) {
		empleadoRepository.save(empleado);
		
	}

	@Override
	public void borrar(Empleado empleado) {
		empleadoRepository.delete(empleado);
		
	}

	@Override
	public Optional<Empleado> findById(Long id) {
		// TODO Auto-generated method stub
		return empleadoRepository.findById(id);
	}

}
