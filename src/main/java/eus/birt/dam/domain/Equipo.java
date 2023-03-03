package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="equipo")
public class Equipo extends BaseEntity {
	
	

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ciudad")
	private String ciudad;
	
	@Column(name="presupuesto")
	private Double presupuesto;
	
	@OneToMany (mappedBy = "equipo",cascade = CascadeType.ALL)
	private List <Atleta> atletas = new ArrayList<>();
	
	public Equipo() {

	}

	public Equipo(String nombre, String ciudad, Double presupuesto) {
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.presupuesto = presupuesto;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}
	
}
