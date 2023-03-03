package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Equipo;
import eus.birt.dam.repository.EquipoRepository;

@Controller
@RequestMapping ("/equipos")
public class EquipoController {

	@Autowired
	EquipoRepository equipoRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		equipoRepository.deleteById(id);
	return "redirect:/equipos";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Equipo equipo = new Equipo();
		model.addAttribute("equipo", equipo);
		return "formulario_equipo";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Equipo equipo) {
		equipoRepository.save(equipo);
		return "redirect:/equipos";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") int id, Model model) {	
		model.addAttribute("equipo", equipoRepository.findById(id));
		return "formulario_equipo";
	}
}
