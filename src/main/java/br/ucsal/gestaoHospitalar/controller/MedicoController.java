package br.ucsal.gestaoHospitalar.controller;

import java.util.ArrayList;
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
import br.ucsal.gestaoHospitalar.entity.Paciente;
import br.ucsal.gestaoHospitalar.service.FuncionarioService;
import br.ucsal.gestaoHospitalar.service.PacienteService;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
    private FuncionarioService service;
	@GetMapping()
	public String viewMedicoPage(Model model) {
		model.addAttribute("medicos", service.findAll());
		return "medico";
	}

	@GetMapping("/inserir")
	public String exibirFormMedico(Model model) {
		List<String> especialidades = new ArrayList();
		especialidades.add(Especialidade.Anestegista.name());
		especialidades.add(Especialidade.Cirurgião.name());
		especialidades.add(Especialidade.Fisioterapeota.name());
		especialidades.add(Especialidade.Psicologo.name());
		
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("medico", new Medico());
		return "new_medicos";
	}
	
	@PostMapping("/inserir")
	public String inserirMedico(@Validated Medico medico, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "index";
        }
		service.insert(medico);
		return "redirect:/medico";
	}
	
	
	@GetMapping("/editar/{id}")
	public String editarMedico(@PathVariable("id") Long id, Model model) {
		Medico medico = (Medico) service.getFuncionario(id);
		
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
		return "redirect:/medico";
	}
	
	@GetMapping("/delete/{id}")
	public String deletarMedico(@PathVariable("id") Long id, Model model) {
		Funcionario medico = service.getFuncionario(id);
		if(medico != null)
			service.delete(medico);
			
		model.addAttribute("medicos", service.findAll());
		return "redirect:/medico";
	}
}

