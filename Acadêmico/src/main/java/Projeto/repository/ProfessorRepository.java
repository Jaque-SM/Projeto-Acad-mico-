package Projeto.repository;

import Projeto.modelo.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long>{

			Professor findByEmail(String email);	
			
	
	
	
	
	
}
