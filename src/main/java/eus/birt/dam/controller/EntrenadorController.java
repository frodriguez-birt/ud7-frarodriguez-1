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

import eus.birt.dam.domain.Entrenador;
import eus.birt.dam.repository.EntrenadorRepository;

@RestController
@RequestMapping ("api/entrenadores")
public class EntrenadorController {
	
	@Autowired
   	private EntrenadorRepository entrenadorRepository;
		
	@GetMapping({"/",""})
	public List <Entrenador> index() {
	return entrenadorRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Entrenador show(@PathVariable("id") Long id) {
		return entrenadorRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Entrenador create(@RequestBody Entrenador entrenador) {
		return entrenadorRepository.save(entrenador);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Entrenador update(@RequestBody Entrenador entrenador, @PathVariable("id") Long id) {
		Entrenador tempEntrenador = entrenadorRepository.findById(id).orElse(null);
		
		tempEntrenador.setNombre(entrenador.getNombre());
		tempEntrenador.setApellido(entrenador.getApellido());
		tempEntrenador.setExperiencia(entrenador.getExperiencia());
		//Al ser un id diferente, el método save hace en realidad un update
		return entrenadorRepository.save(tempEntrenador);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		entrenadorRepository.deleteById(id);
	}	

}
