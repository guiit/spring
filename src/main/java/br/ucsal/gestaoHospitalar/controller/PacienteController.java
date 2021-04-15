package br.ucsal.gestaoHospitalar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.gestaoHospitalar.entity.Paciente;
import br.ucsal.gestaoHospitalar.service.PacienteService;

@Controller
@RequestMapping("/pacientes")
public class PacienteController {	
	
    @Autowired
    private PacienteService service;
	@GetMapping(path="")
	public String viewPacientePage(Model model) {
		List<Paciente> pacientes = service.gePacientes();
		model.addAttribute("pacientes", pacientes);

		return "pacientes";
	}


	@GetMapping("/consultar")
	public String exibirFormConsultar(Model model) {
		
		return "consultar-paciente";
	}
	
	@PostMapping("/consultar/{id}")
	public String consultarPaciente(@PathVariable(name = "id") Long id, Model model) {
		Paciente paciente = service.getPaciente(id);
		
		if(paciente == null)
			throw new IllegalArgumentException("Não existe paciente no sistema com este ID: "+id);
		
		model.addAttribute("paciente", paciente);
		return "consultar-paciente";
	}
	
	@GetMapping("/inserir")
	public String exibirFormPaciente(Model model) {
		
		return "paciente-form";
	}
	
	@GetMapping(path="/new-paciente")
	public String viewPacienteaPage(Model model) {
		
		return "new_pacientes";
	}
	
	@PostMapping(path="/new-paciente")
	public String inserirPaciente(@Validated Paciente paciente, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "index";
        }
		service.insert(paciente);
		return "redirect:/pacientes";
	}
	
	
	@GetMapping("/editar/{id}")
	public String editarPaciente(@PathVariable("id") Long id, Model model) {
		Paciente paciente = service.getPaciente(id);
		
		if(paciente == null)
			throw new IllegalArgumentException("Não existe paciente no sistema com este ID: "+id);
		
		model.addAttribute("paciente", paciente);
		return "editar-paciente";
	}
	
	@PostMapping("/editar/{id}")
	public String editarPaciente(@PathVariable("id") long id, @Validated Paciente paciente, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			paciente.setIdPessoa(id);
			return "editar-paciente";
		}
			        
		service.insert(paciente);
		return "redirect:/consultar-paciente";
	}
}
