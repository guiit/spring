package br.ucsal.gestaoHospitalar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
	@GetMapping("/consultar")
	public String consultarPacientes(String index) {
		
		return "index";
	}
	
	@PostMapping("/consultar")
	public String consultarPaciente(String index) {
		
		return "index";
	}
	
	@GetMapping("/inserir")
	public String inserirPacientes(String index) {
		
		return "index";
	}
	
	@PostMapping("/inserir")
	public String inserirPaciente(String index) {
		
		return "index";
	}
}
