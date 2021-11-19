package Projeto.implemento;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.modelo.Aluno;
import Projeto.repository.AlunoRepository;
import Projeto.service.AlunoService;
import domainException.NegocioException;

@Service
public class AlunoServiceImpl implements AlunoService{

	@Autowired
	private AlunoRepository alunoR;
	
	
	@Override
	public Aluno adicionarAluno(Aluno al) {
		Aluno aluno1=alunoR.findByEmail(al.getEmail());
		
		if (aluno1!=null&&aluno1.equals(al)) {
			throw new NegocioException("Ja existe um aluno com esse email");

		}
		
		return alunoR.save(al);
	}

	@Override
	public Aluno atualizaAluno(Long id, Aluno al) {
		if (alunoR.existsById(id)) {
			return null;
		}
		al.setId(id);
		al=alunoR.save(al);
		return al;
		
	}

	@Override
	public Aluno removeAluno(Long id) {
		var aluno2=buscarPorID(id);
		
		if (!alunoR.existsById(id)) {
			return null;
		}
		alunoR.deleteById(id);

		return aluno2;
	}

	@Override
	public List<Aluno> buscarAluno() {
		return alunoR.findAll();
	}

	@Override
	public Aluno buscarPorID(Long id) {
		Optional<Aluno> aluno1=alunoR.findById(id);
		
		if (aluno1.isPresent()) {
			return aluno1.get();
		}
		
		return null;
	}

	@Override
	public Boolean existeAlunoPorId(Long profId) {
		if (!alunoR.existsById(profId)) {
			return false;
		}
		
		return true;
	}

	@Override
	public Aluno findByEmail(String email) {
		Aluno aluno1=alunoR.findByEmail(email);
		if (aluno1!=null){
			return aluno1;
		}
		return null;
	}

}
