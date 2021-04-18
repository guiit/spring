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
import br.ucsal.gestaoHospitalar.entity.Medicamento;
import br.ucsal.gestaoHospitalar.service.MedicamentoService;

@Controller
@RequestMapping("/medicamentos")
public class MedicamentoController {
	@Autowired
	private MedicamentoService service;
	@GetMapping()
	public String exibirFormConsultar(Model model) {
		
		List<Medicamento> medicamentos = service.findAll();
		model.addAttribute("medicamentos", medicamentos);
		
		return "medicamentos";
	}
	
	@GetMapping("/inserir")
	public String exibirFormMedicamento(Model model) {
		
		model.addAttribute("medicamento", new Medicamento());
		
		return "new_medicamento";
	}
	
	@PostMapping("/inserir")
	public String inserirMedicamento(@Validated Medicamento medicamento, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "redirect:/";
        }
		service.insert(medicamento);
		return "redirect:/medicamentos";
	}
	
	@GetMapping("/editar/{id}")
	public String get(@PathVariable("id") Long id, Model model) {

		Medicamento medicamento = service.getMedicamento(id);
		if(medicamento == null)
			throw new IllegalArgumentException("Não existe medicamento no sistema com este ID: "+id);
		model.addAttribute("medicamento", medicamento);



		return "editar_medicamento";
	}
	
	@PostMapping("/editar/{id}")
	public String editarMedicamento(@PathVariable("id") long id, @Validated Medicamento medicamento, 
			  BindingResult result, Model model) {
		service.insert(medicamento);
		
		return "redirect:/medicamentos";
	}
	
		@GetMapping("/by/deletar/{id}")
	public String deletarMedicamento(@PathVariable("id") long id, Model model) {
		Medicamento medicamento = service.getMedicamento(id);
		if(medicamento == null)
			throw new IllegalArgumentException("Não existe medicamento no sistema com este ID: "+id);
		service.delete(medicamento);
		
		return "redirect:/medicamentos";
	}
	
}
