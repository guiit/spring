package br.ucsal.gestaoHospitalar.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

import br.ucsal.gestaoHospitalar.entity.Especialidade;
import br.ucsal.gestaoHospitalar.entity.Funcionario;
import br.ucsal.gestaoHospitalar.entity.Medico;
import br.ucsal.gestaoHospitalar.service.MedicoService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
    private MedicoService service;
	@GetMapping()
	public String viewMedicoPage(Model model) {
		model.addAttribute("medicos", service.findAll());
		return "medico";
	}

	@GetMapping("/inserir")
	public String exibirFormMedico(Model model) {
			
		model.addAttribute("especialidades", Especialidade.values());
		model.addAttribute("medico", new Medico());
		return "new_medicos";
	}
	
	@PostMapping("/inserir")
	public String inserirMedico(@Validated Medico medico, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "index";
        }
		service.insert(medico);
		return "redirect:/medicos";
	}
	
	
	@GetMapping("/editar/{id}")
	public String editarMedico(@PathVariable("id") Long id, Model model) {
		Medico medico = service.getMedico(id);
		
		if(medico == null)
			throw new IllegalArgumentException("Não existe paciente no sistema com este ID: "+id);
		
		model.addAttribute("medico", medico);
		return "editar_medico";
	}
	
	@PostMapping("/editar/{id}")
	public String editarMedico(@PathVariable("id") long id, @Validated Medico medico, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			medico.setIdPessoa(id);
			return "editar_medico";
		}
			        
		service.insert(medico);
		return "redirect:/medicos";
	}
	
	@GetMapping("/delete/{id}")
	public String deletarMedico(@PathVariable("id") Long id, Model model) {
		Medico medico = service.getMedico(id);
		if(medico != null)
			service.delete(medico);
			
		model.addAttribute("medicos", service.findAll());
		return "redirect:/medicos";
	}
}

