package org.cifpaviles.unidireccional.one_to_one;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name="uni_empleado_one_one")
@Table(name="uni_empleado_one_to_one")
public class Empleado {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;
	@OneToOne
	@JoinColumn(name="parkingId")
	private Parking parking;
	
	private String nombreEmpleado;
	private String turnoEmpleado;
}
