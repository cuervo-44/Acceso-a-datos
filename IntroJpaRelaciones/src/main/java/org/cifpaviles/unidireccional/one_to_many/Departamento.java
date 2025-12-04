package org.cifpaviles.unidireccional.one_to_many;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity(name="uni_departamento_one_many")
@Table(name="uni_departamento_one_to_many")

public class Departamento {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	
	@OneToMany
	@JoinColumn(name="idDepartamento")
	private List <Empleado> empleados;
}
