package org.cifpaviles.practicaSpring.repositories;

import java.util.List;

import org.cifpaviles.practicaSpring.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
	
	@Query("select e from Empleado where e.nombre =?1 nombre	")
	List<Cliente> findByEdadGreaterThan(String nombre);

}
