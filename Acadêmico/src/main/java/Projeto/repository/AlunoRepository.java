package Projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Projeto.modelo.Aluno;
import Projeto.modelo.Professor;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>  {
	
	Aluno findByEmail(String email);	


}
