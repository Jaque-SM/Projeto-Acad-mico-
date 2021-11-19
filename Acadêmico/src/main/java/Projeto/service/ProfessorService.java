package Projeto.service;
import Projeto.modelo.*;
import java.util.List;


public interface ProfessorService {
	
	public abstract Professor addProf (Professor prof);
	public abstract Professor atualizaProf (Long id, Professor prof);
	public abstract Professor removeProf (Long id);
	public abstract List <Professor> buscarProf();
	public abstract Professor buscarProfessorPorId (Long id);
	public abstract Boolean existeProfessorPorId(Long profId);
	public abstract Professor findByEmail(String email);
	

}
