package org.cifpaviles.unidireccional.many_to_one;

import org.cifpaviles.bidireccional.many_to_one.Escuela;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="uni_estudiante_many_to_one")
@Table(name="uni_estudiate_many_to_one")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="idEscuela")
	private Escuela escuela;
}
