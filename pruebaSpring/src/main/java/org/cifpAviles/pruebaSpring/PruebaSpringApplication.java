package org.cifpAviles.pruebaSpring;

import org.cifpAviles.pruebaSpring.entities.Empleado;
import org.cifpAviles.pruebaSpring.services.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaSpringApplication implements CommandLineRunner{
	
	@Autowired
	EmpleadoServiceImpl empleadoService;

	public static void main(String[] args) {
		SpringApplication.run(PruebaSpringApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) {
		System.out.println("Hola muundo");
		
		Empleado e = new Empleado();
		e.setNombre("Sergio");
		empleadoService.insert(e);
		
	}

}
