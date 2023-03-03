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
@Table(name="entrenador")
public class Entrenador extends BaseEntity {
	
	

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="experiencia")
	private int experiencia;
	
	@OneToMany (mappedBy = "entrenador",cascade = CascadeType.ALL)
	private List <Atleta> atletas = new ArrayList<>();
	
	public Entrenador() {
	}

	public Entrenador(String nombre, String apellido, int experiencia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.experiencia = experiencia;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public List<Atleta> getAtletas() {
		return atletas;
	}

	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}

	
}
