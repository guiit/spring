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

import br.ucsal.gestaoHospitalar.entity.Funcionario;
import br.ucsal.gestaoHospitalar.entity.Paciente;
import br.ucsal.gestaoHospitalar.service.FuncionarioService;
import br.ucsal.gestaoHospitalar.service.HistoricoService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	@Autowired
	private FuncionarioService service;
	@GetMapping()
	public String exibirFormConsultar(Model model) {
		
		List<Funcionario> funcionarios = service.findAll();
		model.addAttribute("funcionarios", funcionarios);
		
		return "funcionario";
	}
	
	@GetMapping("/inserir")
	public String exibirFormFuncionario(Model model) {
		
		model.addAttribute("funcionario", new Funcionario());
		
		return "new_funcionario";
	}
	
	@PostMapping("/inserir")
	public String inserirFuncionario(@Validated Funcionario funcionario, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "redirect:/";
        }
		service.insert(funcionario);
		return "redirect:/funcionario";
	}
	
	@GetMapping("/editar/{id}")
	public String get(@PathVariable("id") Long id, Model model) {

		Funcionario funcionario = service.getFuncionario(id);
		if(funcionario == null)
			throw new IllegalArgumentException("Não existe funcionario no sistema com este ID: "+id);
		model.addAttribute("funcionario", funcionario);



		return "editar_funcionario";
	}
	
	@PostMapping("/editar/{id}")
	public String editarFuncionario(@PathVariable("id") long id, @Validated Funcionario funcionario, 
			  BindingResult result, Model model) {
		service.insert(funcionario);
		
		return "redirect:/funcionario";
	}
	
	@GetMapping("/by/deletar/{id}")
	public String deletarFuncionário(@PathVariable("id") long id, Model model) {
		Funcionario funcionario = service.getFuncionario(id);
		if(funcionario == null)
			throw new IllegalArgumentException("Não existe funcionario no sistema com este ID: "+id);
		service.delete(funcionario);
		
		return "redirect:/funcionario";
	}
	
	
}
