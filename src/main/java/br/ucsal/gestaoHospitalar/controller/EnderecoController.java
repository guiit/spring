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

import br.ucsal.gestaoHospitalar.entity.Endereco;
import br.ucsal.gestaoHospitalar.service.EnderecoService;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {
	@Autowired
	private EnderecoService service;
	@GetMapping()
	public String exibirFormConsultar(Model model) {
		
		List<Endereco> enderecos = service.findAll();
		model.addAttribute("enderecos", enderecos);
		
		return "enderecos";
	}
	
	@GetMapping("/inserir")
	public String exibirFormEndereco(Model model) {
		
		model.addAttribute("endereco", new Endereco());
		
		return "new_endereco";
	}
	
	@PostMapping("/inserir")
	public String inserirEndereco(@Validated Endereco endereco, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "endereco-form";
        }
		service.insert(endereco);
		return "redirect:/enderecos";
	}
	
	@GetMapping("/editar/{id}")
	public String editarEndereco(@PathVariable("id") Long id, Model model) {
		Endereco endereco = service.getEndereco(id);
		
		if(endereco == null)
			throw new IllegalArgumentException("Não existe endereço no sistema com este ID: "+id);
		
		model.addAttribute("endereco", endereco);
		return "editar_endereco";
	}
	
	@PostMapping("/editar/{id}")
	public String editarEndereco(@PathVariable("id") long id, @Validated Endereco endereco, 
			  BindingResult result, Model model) {
        
		service.insert(endereco);
		return "redirect:/enderecos";
	}
	
	@GetMapping("/delete/{id}")
	public String deletarEndereco(@PathVariable("id") Long id, Model model) {
		Endereco endereco = service.getEndereco(id);
		
		if(endereco == null)
			throw new IllegalArgumentException("Não existe paciente no sistema com este ID: "+id);
		
		model.addAttribute("endereco", endereco);
		return "redirect:/pacientes";
	}
	
}
