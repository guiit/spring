package br.ucsal.gestaoHospitalar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ucsal.gestaoHospitalar.entity.Medicacao;
import br.ucsal.gestaoHospitalar.service.HistoricoService;
import br.ucsal.gestaoHospitalar.service.MedicacaoService;

@Controller
@RequestMapping("/medicacao")
public class MedicacaoController {
	@Autowired
	private MedicacaoService service;
	@GetMapping("/consultar")
	public String exibirFormConsultar(Model model) {
		
		return "consultar-medicacao";
	}
	
	@PostMapping("/consultar/{id}")
	public String consultarMedicacao(@PathVariable(name = "id") Long id, Model model) {
		Medicacao medicacao = service.getMedicacao(id);
			    
		if(medicacao == null)
			throw new IllegalArgumentException("Não existe uma medicação no sistema com este ID: "+id);
		model.addAttribute("medicacao", medicacao);
		return "consultar-medicacao";
	}
	
	@GetMapping("/inserir")
	public String exibirFormMedicacao(Model model) {
		
		return "medicacao-form";
	}
	
	@PostMapping("/inserir")
	public String inserirMedicacao(@Validated Medicacao medicacao, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "medicacao-form";
        }
		service.insert(medicacao);
		return "redirect:/consultar-medicacao";
	}
	
	@GetMapping("/editar/{id}")
	public String editarMedicacao(@PathVariable("id") Long id, Model model) {
		Medicacao medicacao = service.getMedicacao(id);
		
		if(medicacao == null)
			throw new IllegalArgumentException("Não existe uma medicação no sistema com este ID: "+id);
		
		model.addAttribute("medicacao", medicacao);
		return "editar-medicacao";
	}
	
	@PostMapping("/editar/{id}")
	public String editarMedicacao(@PathVariable("id") long id, @Validated Medicacao medicacao, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			medicacao.setId(id);
			return "editar-medicacao";
		}
			        
		service.insert(medicacao);
		return "redirect:/consultar-medicacao";
	}
	
	
}
