package org.cifpaviles.practicaSpring.controller;

import java.util.List;
import org.cifpaviles.practicaSpring.entities.Cliente;
import org.cifpaviles.practicaSpring.services.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cliente")

public class ClienteController {
	
	private ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	@GetMapping("info_clientes")
	public String getCliente(Model model) {
		return "lista_clientes";
	}
	
	@ModelAttribute("clientes")
	public List<Cliente> listaClientes() {
		return clienteService.findAll();
	}
	
	@GetMapping("nuevo_cliente")
	public String mostrarFormulario(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "crearCliente";
		
	}
	
	@PostMapping("add_cliente")
	public String crearCliente(@ModelAttribute Cliente cliente) {
		clienteService.insert(cliente);
		return "pagina_exito";
	}
	
	@GetMapping("buscar_cliente")
	public String mostrarFormularioBuscar (Model model) {
		model.addAttribute("cliente", new Cliente());
		return "get_cliente";
	}
	
	
}
