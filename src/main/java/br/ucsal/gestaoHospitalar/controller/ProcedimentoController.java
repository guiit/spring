package br.ucsal.gestaoHospitalar.controller;

import java.util.ArrayList;
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

import br.ucsal.gestaoHospitalar.entity.Enfermeiro;
import br.ucsal.gestaoHospitalar.entity.Espaco;
import br.ucsal.gestaoHospitalar.entity.Funcionario;
import br.ucsal.gestaoHospitalar.entity.Medico;
import br.ucsal.gestaoHospitalar.entity.Procedimento;
import br.ucsal.gestaoHospitalar.service.EnfermeiroService;
import br.ucsal.gestaoHospitalar.service.EspacoService;
import br.ucsal.gestaoHospitalar.service.MedicoService;
import br.ucsal.gestaoHospitalar.service.ProcedimentoService;

@Controller
@RequestMapping("/procedimento")
public class ProcedimentoController {
	@Autowired
	private ProcedimentoService service;
	private EspacoService serviceEs;
	private MedicoService serviceM;
	private EnfermeiroService serviceEn;
	@GetMapping()
	public String exibirConsultar(Model model) {
		List<Procedimento> procedimentos = service.findAll();
		model.addAttribute("procedimentos", procedimentos);
		
		return "procedimentos";
	}
	
	@GetMapping("/inserir")
	public String exibirFormProcedimento(Model model) {
		List<Medico>medicos = serviceM.findAll();
		List<Enfermeiro> enfermeiros = serviceEn.findAll();
		List<Funcionario> funcionarios = new ArrayList();
		funcionarios.addAll(medicos);
		funcionarios.addAll(enfermeiros);
		
		List<Espaco> espacos = serviceEs.findAll();
		
		model.addAttribute("procedimento", new Procedimento());
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("espacos", espacos);
		
		return "new_procedimento";
	}
	
	@PostMapping("/inserir")
	public String inserirProcedimento(@Validated Procedimento procedimento, BindingResult result, Model model) {
		if (result.hasErrors()) {
            return "redirect:/";
        }
		service.insert(procedimento);
		return "redirect:/procedimentos";
	}
	
	@GetMapping("/editar/{id}")
	public String get(@PathVariable("id") Long id, Model model) {

		Procedimento procedimento = service.getProcedimento(id);
		if(procedimento == null)
			throw new IllegalArgumentException("Não existe procedimento no sistema com este ID: "+id);
		
		List<Medico>medicos = serviceM.findAll();
		List<Enfermeiro> enfermeiros = serviceEn.findAll();
		List<Funcionario> funcionarios = new ArrayList();
		funcionarios.addAll(medicos);
		funcionarios.addAll(enfermeiros);
		
		List<Espaco> espacos = serviceEs.findAll();
		
		model.addAttribute("procedimento", new Procedimento());
		model.addAttribute("funcionarios", funcionarios);
		model.addAttribute("espacos", espacos);
		

		return "editar_procedimento";
	}
	
	@PostMapping("/editar/{id}")
	public String editarProcedimento(@PathVariable("id") long id, @Validated Procedimento procedimento, 
			  BindingResult result, Model model) {
		service.insert(procedimento);
		
		return "redirect:/procedimento";
	}
	
	@GetMapping("/deletar/{id}")
	public String deletarProcedimento(@PathVariable("id") long id, Model model) {
		Procedimento procedimento = service.getProcedimento(id);
		if(procedimento == null)
			throw new IllegalArgumentException("Não existe procedimento no sistema com este ID: "+id);
		service.delete(procedimento);
		
		return "redirect:/procedimentos";
	}
	
	
}
