package org.cifpaviles.unidireccional.many_to_one;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="uni_escuela_many_to_one")
@Table(name="uni_escuela_many_to_one")
public class Escuela {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	private List<Estudiante> estudiantes;
	

}
