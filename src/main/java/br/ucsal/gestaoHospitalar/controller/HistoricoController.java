package br.ucsal.gestaoHospitalar.controller;

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
	private HistoricoService service = new HistoricoService(); 
	@GetMapping("/consultar")
	public String exibirFormConsultar(Model model) {
		
		return "consultar-historico";
	}
	
	@PostMapping("/consultar/{id}")
	public String consultarHistorico(@PathVariable(name = "id") Long id, Model model) {
		Historico historico = service.getHistorico(id);
			    
		if(historico == null)
			throw new IllegalArgumentException("Não existe um histórico no sistema com este ID: "+id);
		model.addAttribute("historico", historico);
		return "consultar-historico";
	}
	
	@GetMapping("/inserir")
	public String exibirFormHistorico(Model model) {
		
		return "historico-form";
	}
	
	@PostMapping("/inserir")
	public String inserirHistorico(@Validated Historico historico, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "historico-form";
        }
		service.insert(historico);
		return "redirect:/consultar-historico";
	}
	
	@GetMapping("/editar/{id}")
	public String editarHistorico(@PathVariable("id") Long id, Model model) {
		Historico historico = service.getHistorico(id);
		
		if(historico == null)
			throw new IllegalArgumentException("Não existe um histórico no sistema com este ID: "+id);
		
		model.addAttribute("historico", historico);
		return "editar-historico";
	}
	
	@PostMapping("/editar/{id}")
	public String editarHistorico(@PathVariable("id") long id, @Validated Historico historico, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			historico.setId(id);
			return "editar-historico";
		}
			        
		service.insert(historico);
		return "redirect:/consultar-historico";
	}
	
	
}
