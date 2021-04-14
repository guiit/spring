package br.ucsal.gestaoHospitalar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import br.ucsal.gestaoHospitalar.entity.Medicamento;
import br.ucsal.gestaoHospitalar.service.MedicamentoService;

@Controller
@RequestMapping("/medicamento")
public class MedicamentoController {
	private MedicamentoService service = new MedicamentoService(); 
	@GetMapping("/consultar")
	public String exibirFormConsultar(Model model) {
		
		return "consultar-medicamento";
	}
	
	@PostMapping("/consultar/{id}")
	public String consultarMedicamento(@PathVariable(name = "id") Long id, Model model) {
		Medicamento medicamento = service.getMedicamento(id);
			    
		if(medicamento == null)
			throw new IllegalArgumentException("Não existe um medicamento no sistema com este ID: "+id);
		model.addAttribute("medicamento", medicamento);
		return "consultar-medicamento";
	}
	
	@GetMapping("/inserir")
	public String exibirFormMedicamento(Model model) {
		
		return "medicamento-form";
	}
	
	@PostMapping("/inserir")
	public String inserirMedicamento(@Validated Medicamento medicamento, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "medicamento-form";
        }
		service.insert(medicamento);
		return "redirect:/consultar-medicamento";
	}
	
	@GetMapping("/editar/{id}")
	public String editarMedicamento(@PathVariable("id") Long id, Model model) {
		Medicamento medicamento = service.getMedicamento(id);
		
		if(medicamento == null)
			throw new IllegalArgumentException("Não existe um medicamento no sistema com este ID: "+id);
		
		model.addAttribute("medicamento", medicamento);
		return "editar-medicamento";
	}
	
	@PostMapping("/editar/{id}")
	public String editarMedicamento(@PathVariable("id") long id, @Validated Medicamento medicamento, 
			  BindingResult result, Model model) {
		 if (result.hasErrors()) {
			medicamento.setId(id);
			return "editar-medicamento";
		}
			        
		service.insert(medicamento);
		return "redirect:/consultar-medicamento";
	}
	
	
}
