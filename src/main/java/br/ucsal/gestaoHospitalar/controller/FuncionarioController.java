package br.ucsal.gestaoHospitalar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {

	@GetMapping("/consultar")
	public String consultarFuncionarios(String index) {
		
		return "index";
	}
	
	@PostMapping("/consultar")
	public String consultarFuncionario(String index) {
		
		return "index";
	}
	
	@GetMapping("/inserir")
	public String inserirFuncionarios(String index) {
		
		return "index";
	}
	
	@PostMapping("/inserir")
	public String inserirFuncionario(String index) {
		
		return "index";
	}
}
