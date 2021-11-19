package Projeto.service;

import java.util.List;

import Projeto.modelo.Aluno;
import Projeto.modelo.Professor;

public interface AlunoService {
	
	public abstract Aluno adicionarAluno (Aluno al);
	public abstract Aluno atualizaAluno (Long id, Aluno al);
	public abstract Aluno removeAluno (Long id);
	public abstract List <Aluno> buscarAluno();
	public abstract Aluno buscarPorID (Long id);
	public abstract Boolean existeAlunoPorId(Long profId);
	public abstract Aluno findByEmail(String email);


}
