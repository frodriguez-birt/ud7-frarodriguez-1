package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Entrenador;
import eus.birt.dam.repository.EntrenadorRepository;

@Controller
@RequestMapping ("/entrenadores")
public class EntrenadorController {
	
	@Autowired
   	private EntrenadorRepository entrenadorRepository;
		
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		entrenadorRepository.deleteById(id);
	return "redirect:/entrenadores";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Entrenador entrenador = new Entrenador();
		model.addAttribute("entrenador", entrenador);
		return "formulario_entrenador";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Entrenador entrenador) {
		entrenadorRepository.save(entrenador);
		return "redirect:/entrenadores";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {	
		model.addAttribute("entrenador", entrenadorRepository.findById(id));
		return "formulario_equipo";
	}	

}
