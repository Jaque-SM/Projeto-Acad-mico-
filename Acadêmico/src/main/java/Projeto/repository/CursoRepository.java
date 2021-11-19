package Projeto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import Projeto.modelo.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);
	
	


}
