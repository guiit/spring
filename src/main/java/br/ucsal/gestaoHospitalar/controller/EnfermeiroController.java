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

import br.ucsal.gestaoHospitalar.entity.Enfermeiro;
import br.ucsal.gestaoHospitalar.entity.Especialidade;
import br.ucsal.gestaoHospitalar.entity.Funcionario;
import br.ucsal.gestaoHospitalar.entity.Medico;
import br.ucsal.gestaoHospitalar.service.FuncionarioService;

@Controller
@RequestMapping("/enfermeiros")
public class EnfermeiroController {

	@Autowired
    private FuncionarioService service;
	@GetMapping()
	public String viewEnfermeiroPage(Model model) {
		model.addAttribute("enfermeiros", service.findAll());
		return "enfermeiros";
	}

	@GetMapping("/inserir")
	public String exibirFormEnfermeiro(Model model) {
		List<String> especialidades = new ArrayList();
		especialidades.add(Especialidade.Anestegista.name());
		especialidades.add(Especialidade.Cirurgião.name());
		especialidades.add(Especialidade.Fisioterapeota.name());
		especialidades.add(Especialidade.Psicologo.name());
		
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("enfermeiro", new Enfermeiro());
		return "new_enfermeiro";
	}
	
	@PostMapping("/inserir")
	public String inserirEnfermeiro(@Validated Enfermeiro enfermeiro, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "index";
        }
		service.insert(enfermeiro);
		return "redirect:/enfermeiros";
	}
	
	
	@GetMapping("/editar/{id}")
	public String editarEnfermeiro(@PathVariable("id") Long id, Model model) {
		Enfermeiro enfermeiro = (Enfermeiro) service.getFuncionario(id);
		
		if(enfermeiro == null)
			throw new IllegalArgumentException("Não existe paciente no sistema com este ID: "+id);
		
		model.addAttribute("enfermeiro", enfermeiro);
		return "editar_enfermeiro";
	}
	
	@PostMapping("/editar/{id}")
	public String editarEnfermeiro(@PathVariable("id") long id, @Validated Enfermeiro enfermeiro, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			enfermeiro.setIdPessoa(id);
			return "editar_medico";
		}
			        
		service.insert(enfermeiro);
		return "redirect:/enfermeiros";
	}
	
	@GetMapping("/delete/{id}")
	public String deletarEnfermeiro(@PathVariable("id") Long id, Model model) {
		Funcionario enfermeiro = service.getFuncionario(id);
		if(enfermeiro != null)
			service.delete(enfermeiro);
			
		model.addAttribute("enfermeiros", service.findAll());
		return "redirect:/enfermeiros";
	}
}
