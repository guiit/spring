package br.ucsal.gestaoHospitalar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ucsal.gestaoHospitalar.entity.Funcionario;
import br.ucsal.gestaoHospitalar.service.FuncionarioService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	private FuncionarioService service = new FuncionarioService(); 
	@GetMapping("/consultar")
	public String exibirFormConsultar(Model model) {
		
		return "consultar-funcionario";
	}
	
	@PostMapping("/consultar/{id}")
	public String consultarFuncionario(@PathVariable(name = "id") Long id, Model model) {
		Funcionario funcionario = service.getFuncionario(id);
			    
		if(funcionario == null)
			throw new IllegalArgumentException("Não existe funcionario no sistema com este ID: "+id);
		model.addAttribute("funcionario", funcionario);
		return "consultar-funcionario";
	}
	
	@GetMapping("/inserir")
	public String exibirFormFuncionario(Model model) {
		
		return "funcionario-form";
	}
	
	@PostMapping("/inserir")
	public String inserirFuncionario(@Validated Funcionario funcionario, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "funcionario-form";
        }
		service.insert(funcionario);
		return "redirect:/consultar-funcionario";
	}
	
	@GetMapping("/editar/{id}")
	public String editarFuncionario(@PathVariable("id") Long id, Model model) {
		Funcionario funcionario = service.getFuncionario(id);
		
		if(funcionario == null)
			throw new IllegalArgumentException("Não existe funcionario no sistema com este ID: "+id);
		
		model.addAttribute("funcionario", funcionario);
		return "editar-funcionario";
	}
	
	@PostMapping("/editar/{id}")
	public String editarPaciente(@PathVariable("id") long id, @Validated Funcionario funcionario, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			funcionario.setIdPessoa(id);
			return "editar-funcionario";
		}
			        
		service.insert(funcionario);
		return "redirect:/consultar-funcionario";
	}
	
	
}