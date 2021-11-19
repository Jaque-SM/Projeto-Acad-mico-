package Projeto.implemento;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.modelo.Aluno;
import Projeto.modelo.Turma;
import Projeto.repository.AlunoRepository;
import Projeto.repository.TurmaRepository;
import Projeto.service.TurmaService;
import domainException.NegocioException;

@Service
public class TurmaServiceImpl implements TurmaService{

	@Autowired
	private TurmaRepository turma;
	
	@Autowired
	private AlunoRepository aluno;
	
	
	@Override
	public Turma adicionarTurma(Turma al) {
				
		if (al.getAluno().getId()== null) {
			throw new NegocioException("Aluno não encontrado");

		}
		Aluno mate=aluno.findById(al.getAluno().getId()).
				orElseThrow(()->new NegocioException("Aluno não existe :("));
			al.setAluno(mate);
			

					
			return turma.save(al);
			
				

	}

	@Override
	public Turma atualizaTurma(Long id, Turma al) {
		if (!turma.existsById(id)) {
			throw new NegocioException("Turma inexistente");
		}
		al.setId(id);
		al=turma.save(al);
		return al;
	}

	@Override
	public Turma removeTurma(Long id) {
		var tm=buscarPorID(id);
		
		if (!turma.existsById(id)) {
			return null;
		}

		turma.deleteById(id);
		return tm;
	}

	@Override
	public List<Turma> buscarTurma() {
		return turma.findAll();
	}

	@Override
	public Turma buscarPorID(Long id) {
		Optional <Turma> tm=turma.findById(id);
		
		if (tm.isPresent()) {
			return tm.get();
		}
		return null;
	}

	@Override
	public Boolean existeTurmaPorId(Long id) {
		if (!turma.existsById(id)) {
			return false;
		}
		return true;
		
	}



}
