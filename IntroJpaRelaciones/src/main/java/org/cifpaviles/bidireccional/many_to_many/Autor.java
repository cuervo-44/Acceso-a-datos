package org.cifpaviles.bidireccional.many_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity(name="bi_autor_many_to_many")
@Table(name="bi_autor_many_many_many")
public class Autor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	@ManyToMany(mappedBy="autores")
	private List<Libro> libros; 

}
