package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Atleta;
import eus.birt.dam.repository.AtletaRepository;
import eus.birt.dam.repository.EntrenadorRepository;
import eus.birt.dam.repository.EquipoRepository;

@Controller
@RequestMapping ("/atletas")
public class AtletaController {

	@Autowired
	AtletaRepository atletaRepository;
	
	@Autowired
	EquipoRepository equipoRepository;
	
	@Autowired
   	private EntrenadorRepository entrenadorRepository;
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") int id) {
		atletaRepository.deleteById(id);
		return "redirect:/atletas";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Atleta atleta = new Atleta();
		model.addAttribute("atleta", atleta);
		model.addAttribute("equipos", equipoRepository.findAll());
		model.addAttribute("entrenadores", entrenadorRepository.findAll());
		return "formulario_atleta";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Atleta atleta) {
		atletaRepository.save(atleta);
		return "redirect:/atletas";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {	
		model.addAttribute("atleta", atletaRepository.findById(id));
		model.addAttribute("equipos", equipoRepository.findAll());
		model.addAttribute("entrenadores", entrenadorRepository.findAll());
		return "formulario_atleta";
	}
}