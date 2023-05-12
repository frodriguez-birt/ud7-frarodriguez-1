package eus.birt.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import eus.birt.dam.domain.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Long>{
	
}