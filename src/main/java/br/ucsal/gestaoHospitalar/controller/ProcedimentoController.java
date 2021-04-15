package br.ucsal.gestaoHospitalar.controller;

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
	private ProcedimentoService service = new ProcedimentoService(); 
	@GetMapping("/consultar")
	public String exibirFormConsultar(Model model) {
		
		return "consultar-procedimento";
	}
	
	@PostMapping("/consultar/{id}")
	public String consultarProcedimento(@PathVariable(name = "id") Long id, Model model) {
		Procedimento procedimento = service.getProcedimento(id);
			    
		if(procedimento == null)
			throw new IllegalArgumentException("Não existe um procedimento no sistema com este ID: "+id);
		model.addAttribute("procedimento", procedimento);
		return "consultar-procedimento";
	}
	
	@GetMapping("/inserir")
	public String exibirFormProcedimento(Model model) {
		
		return "procedimento-form";
	}
	
	@PostMapping("/inserir")
	public String inserirProcedimento(@Validated Procedimento procedimento, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "procedimento-form";
        }
		service.insert(procedimento);
		return "redirect:/consultar-procedimento";
	}
	
	@GetMapping("/editar/{id}")
	public String getProcedimento(@PathVariable("id") Long id, Model model) {
		Procedimento procedimento = service.getProcedimento(id);
		
		if(procedimento == null)
			throw new IllegalArgumentException("Não existe um procedimento no sistema com este ID: "+id);
		
		model.addAttribute("procedimento", procedimento);
		return "editar-procedimento";
	}
	
	@PostMapping("/editar/{id}")
	public String editarProcedimento(@PathVariable("id") Long id, @Validated Procedimento procedimento, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			 procedimento.setId(id);
			return "editar-procedimento";
		}
			        
		service.update(procedimento);
		return "redirect:/consultar-procedimento";
	}
	
	
}