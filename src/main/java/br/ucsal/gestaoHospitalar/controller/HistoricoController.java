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
import br.ucsal.gestaoHospitalar.entity.Historico;
import br.ucsal.gestaoHospitalar.service.HistoricoService;

@Controller
@RequestMapping("/historico")
public class HistoricoController {
	@Autowired
	private HistoricoService service;
	@GetMapping()
	public String exibirFormConsultar(Model model) {
		
		List<Historico> historicos = service.findAll();
		model.addAttribute("historicos", historicos);
		
		return "historico";
	}
	
	@GetMapping("/inserir")
	public String exibirFormHistorico(Model model) {
		
		model.addAttribute("historico", new Historico());
		
		return "new_historico";
	}
	
	@PostMapping("/inserir")
	public String inserirHistorico(@Validated Historico historico, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "redirect:/";
        }
		service.insert(historico);
		return "redirect:/historico";
	}
	
	@GetMapping("/editar/{id}")
	public String get(@PathVariable("id") Long id, Model model) {

		Historico historico = service.getHistorico(id);
		if(historico == null)
			throw new IllegalArgumentException("Não existe histórico no sistema com este ID: "+id);
		model.addAttribute("historico", historico);



		return "editar_historico";
	}
	
	@PostMapping("/editar/{id}")
	public String editarHistorico(@PathVariable("id") long id, @Validated Historico historico, 
			  BindingResult result, Model model) {
		service.insert(historico);
		
		return "redirect:/historico";
	}
	
	@GetMapping("/by/deletar/{id}")
	public String deletarHistorico(@PathVariable("id") long id, Model model) {
		Historico historico = service.getHistorico(id);
		if(historico == null)
			throw new IllegalArgumentException("Não existe historico no sistema com este ID: "+id);
		service.delete(historico);
		
		return "redirect:/historico";
	}
	
	
}
