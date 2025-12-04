package org.cifpaviles.unidireccional.many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="uni_autor_many_to_many")
@Table(name="uni_autor_many_to_many")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	
	private String nombre;
	private String pseudonimo;
	
	private List<Libro> libros;

}
