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
import br.ucsal.gestaoHospitalar.entity.Espaco;
import br.ucsal.gestaoHospitalar.service.EspacoService;

@Controller
@RequestMapping("/espaco")
public class EspacoController {
	@Autowired
	private EspacoService service;
	@GetMapping()
	public String exibirFormConsultar(Model model) {
		
		List<Espaco> espacos = service.findAll();
		model.addAttribute("espacos", espacos);
		
		return "espaco";
	}
	
	@GetMapping("/inserir")
	public String exibirFormEspaco(Model model) {
		
		model.addAttribute("espaco", new Espaco());
		
		return "new_espaco";
	}
	
	@PostMapping("/inserir")
	public String inserirEspaco(@Validated Espaco espaco, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "redirect:/";
        }
		service.insert(espaco);
		return "redirect:/espaco";
	}
	
	@GetMapping("/editar/{id}")
	public String get(@PathVariable("id") Long id, Model model) {

		Espaco espaco= service.getEspaco(id);
		if(espaco == null)
			throw new IllegalArgumentException("Não existe espaço no sistema com este ID: "+id);
		model.addAttribute("espaco", espaco);



		return "editar_espaco";
	}
	
	@PostMapping("/editar/{id}")
	public String editarespaco(@PathVariable("id") long id, @Validated Espaco espaco, 
			  BindingResult result, Model model) {
		service.insert(espaco);
		
		return "redirect:/espaco";
	}
	
	@GetMapping("/by/deletar/{id}")
	public String deletarEspaco(@PathVariable("id") long id, Model model) {
		Espaco espaco = service.getEspaco(id);
		if(espaco == null)
			throw new IllegalArgumentException("Não existe espaço no sistema com este ID: "+id);
		service.delete(espaco);
		
		return "redirect:/espaco";
	}
	
	
}
