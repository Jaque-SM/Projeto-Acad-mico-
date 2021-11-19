package Projeto.service;

import java.util.List;

import Projeto.modelo.Turma;

public interface TurmaService {

	public abstract Turma adicionarTurma (Turma al);
	public abstract Turma atualizaTurma (Long id, Turma al);
	public abstract Turma removeTurma (Long id);
	public abstract List <Turma> buscarTurma();
	public abstract Turma buscarPorID (Long id);
	public abstract Boolean existeTurmaPorId(Long id);
	
	
	
}
