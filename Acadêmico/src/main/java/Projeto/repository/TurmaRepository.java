package Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projeto.modelo.Professor;
import Projeto.modelo.Turma;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
	Turma findByTurno(String email);	

}
