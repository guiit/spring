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
import br.ucsal.gestaoHospitalar.entity.Procedimento;
import br.ucsal.gestaoHospitalar.service.ProcedimentoService;

@Controller
@RequestMapping("/procedimento")
public class ProcedimentoController {
	@Autowired
	private ProcedimentoService service;
	@GetMapping()
	public String exibirFormConsultar(Model model) {
		
		List<Procedimento> procedimentos = service.findAll();
		model.addAttribute("procedimentos", procedimentos);
		
		return "procedimento";
	}
	
	@GetMapping("/inserir")
	public String exibirFormProcedimento(Model model) {
		
		model.addAttribute("procedimento", new Procedimento());
		
		return "new_procedimento";
	}
	
	@PostMapping("/inserir")
	public String inserirProcedimento(@Validated Procedimento procedimento, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "redirect:/";
        }
		service.insert(procedimento);
		return "redirect:/procedimento";
	}
	
	@GetMapping("/editar/{id}")
	public String get(@PathVariable("id") Long id, Model model) {

		Procedimento procedimento = service.getProcedimento(id);
		if(procedimento == null)
			throw new IllegalArgumentException("Não existe procedimento no sistema com este ID: "+id);
		model.addAttribute("procedimento", procedimento);



		return "editar_procedimento";
	}
	
	@PostMapping("/editar/{id}")
	public String editarProcedimento(@PathVariable("id") long id, @Validated Procedimento procedimento, 
			  BindingResult result, Model model) {
		service.insert(procedimento);
		
		return "redirect:/procedimento";
	}
	
	@GetMapping("/by/deletar/{id}")
	public String deletarProcedimento(@PathVariable("id") long id, Model model) {
		Procedimento procedimento = service.getProcedimento(id);
		if(procedimento == null)
			throw new IllegalArgumentException("Não existe procedimento no sistema com este ID: "+id);
		service.delete(procedimento);
		
		return "redirect:/procedimento";
	}
	
	
}
