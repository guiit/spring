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
import br.ucsal.gestaoHospitalar.entity.Medicacao;
import br.ucsal.gestaoHospitalar.service.MedicacaoService;

@Controller
@RequestMapping("/medicacao")
public class MedicacaoController {
	@Autowired
	private MedicacaoService service;
	@GetMapping()
	public String exibirFormConsultar(Model model) {
		
		List<Medicacao> medicacoes = service.findAll();
		model.addAttribute("medicacoes", medicacoes);
		
		return "medicacoes";
	}
	
	@GetMapping("/inserir")
	public String exibirFormMedicacao(Model model) {
		
		model.addAttribute("medicacao", new Medicacao());
		
		return "new_medicacoes";
	}
	
	@PostMapping("/inserir")
	public String inserirMedicacao(@Validated Medicacao medicacao, BindingResult result, Model model) {
		service.insert(medicacao);
		return "redirect:/medicacao";
	}
	
	@GetMapping("/editar/{id}")
	public String get(@PathVariable("id") Long id, Model model) {
System.out.println("chegou");
		Medicacao medicacao= service.getMedicacao(id);
		if(medicacao == null)
			throw new IllegalArgumentException("Não existe medicacao no sistema com este ID: "+id);
		model.addAttribute("medicacao", medicacao);



		return "editar_medicacao";
	}
	
	@PostMapping("/editar/{id}")
	public String editarMedicacao(@PathVariable("id") long id, @Validated Medicacao medicacao, 
			  BindingResult result, Model model) {
		service.insert(medicacao);
		
		return "redirect:/medicacao";
	}
	
			@GetMapping("/by/deletar/{id}")
	public String deletarMedicacao(@PathVariable("id") long id, Model model) {
		Medicacao medicacao = service.getMedicacao(id);
		if(medicacao == null)
			throw new IllegalArgumentException("Não existe medicacao no sistema com este ID: "+id);
		service.delete(medicacao);
		
		return "redirect:/medicacao";
	}
	
}
