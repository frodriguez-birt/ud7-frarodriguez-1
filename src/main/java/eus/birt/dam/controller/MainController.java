package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.AtletaRepository;
import eus.birt.dam.repository.EntrenadorRepository;
import eus.birt.dam.repository.EquipoRepository;


@Controller
	public class MainController {
	
	@Autowired
	private AtletaRepository atletaRepository;
	@Autowired
   	private EquipoRepository equipoRepository;
	@Autowired
   	private EntrenadorRepository entrenadorRepository;
	
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/atletas"})
	public String getAtletas(Model model) {
		model.addAttribute("atletas", atletaRepository.findAll());
		return "atletas";
	}
	
	@GetMapping ({"/equipos"})
	public String getEquipos(Model model) {
		model.addAttribute("equipos", equipoRepository.findAll());
		return "equipos";
	}
	
	@GetMapping ({"/entrenadores"})
	public String getEntrenadores(Model model) {
		model.addAttribute("entrenadores", entrenadorRepository.findAll());
		return "entrenadores";
	}
}
	

