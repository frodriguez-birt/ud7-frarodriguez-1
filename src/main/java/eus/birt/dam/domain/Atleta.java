package eus.birt.dam.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="atleta")
public class Atleta extends BaseEntity {

	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="marca")
	private String marca;
	
	@Column(name="edad")
	private int edad;
	
	@ManyToOne
	@JoinColumn (name = "id_equipo")
	private Equipo equipo;
	
	@ManyToOne 
	@JoinColumn (name = "id_entrenador")
	private Entrenador entrenador;
	
	public Atleta() {
	}

	public Atleta(String nombre, String apellido, String marca, int edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.marca = marca;
		this.edad = edad;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Entrenador getEntrenador() {
		return entrenador;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}
	
	
	
}
