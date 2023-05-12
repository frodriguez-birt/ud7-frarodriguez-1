package eus.birt.dam.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import eus.birt.dam.domain.Atleta;
import eus.birt.dam.repository.AtletaRepository;
import eus.birt.dam.repository.EntrenadorRepository;
import eus.birt.dam.repository.EquipoRepository;

@RestController
@RequestMapping ("api/atletas")
public class AtletaController {

	@Autowired
	AtletaRepository atletaRepository;
	
	@Autowired
	EquipoRepository equipoRepository;
	
	@Autowired
   	private EntrenadorRepository entrenadorRepository;
	
	@GetMapping({"/",""})
	public List <Atleta> index() {
		return atletaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Atleta show(@PathVariable("id") Long id) {
		return atletaRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Atleta create(@RequestBody Atleta atleta) {
		return atletaRepository.save(atleta);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Atleta update(@RequestBody Atleta atleta, @PathVariable("id") Long id) {
		Atleta tempAtleta = atletaRepository.findById(id).orElse(null);
		
		tempAtleta.setNombre(atleta.getNombre());
		tempAtleta.setApellido(atleta.getApellido());
		tempAtleta.setMarca(atleta.getMarca());
		tempAtleta.setEdad(atleta.getEdad());
		tempAtleta.setEquipo(atleta.getEquipo());
		tempAtleta.setEntrenador(atleta.getEntrenador());
		
		return atletaRepository.save(tempAtleta);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		atletaRepository.deleteById(id);
	}
}