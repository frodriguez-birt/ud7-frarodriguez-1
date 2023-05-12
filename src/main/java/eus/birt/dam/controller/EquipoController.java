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

import eus.birt.dam.domain.Equipo;
import eus.birt.dam.repository.EquipoRepository;

@RestController
@RequestMapping ("api/equipos")
public class EquipoController {

	@Autowired
	EquipoRepository equipoRepository;
	
	@GetMapping({"/",""})
	public List <Equipo> index() {
	return equipoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Equipo show(@PathVariable("id") Long id) {
		return equipoRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"/",""})
	@ResponseStatus (HttpStatus.CREATED)
	public Equipo create(@RequestBody Equipo equipo) {
		return equipoRepository.save(equipo);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Equipo update(@RequestBody Equipo equipo, @PathVariable("id") Long id) {
		Equipo tempEquipo = equipoRepository.findById(id).orElse(null);
		
		tempEquipo.setNombre(equipo.getNombre());
		tempEquipo.setCiudad(equipo.getCiudad());
		tempEquipo.setPresupuesto(equipo.getPresupuesto());
		//Al ser un id diferente, el método save hace en realidad un update
		return equipoRepository.save(tempEquipo);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		equipoRepository.deleteById(id);
	}
}
