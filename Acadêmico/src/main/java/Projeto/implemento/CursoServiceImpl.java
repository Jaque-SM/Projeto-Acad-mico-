package Projeto.implemento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Projeto.modelo.Curso;
import Projeto.modelo.Professor;
import Projeto.repository.CursoRepository;
import Projeto.repository.ProfessorRepository;
import Projeto.service.CursoService;
import domainException.NegocioException;

@Service
public class CursoServiceImpl implements CursoService {
	
	@Autowired
	private CursoRepository CursoRes;
	
	@Autowired
	private ProfessorRepository prof1;
	
	
	@Override
	public Curso inserirCurso(Curso curso) {
		
		Curso cursoExistente = CursoRes.findByNome(curso.getNome());
		
		if (cursoExistente != null && !cursoExistente.equals(curso)) {
		throw new NegocioException("Já existe um curso cadastrado com este nome.");

		}
		if (curso.getProf().getId() == null) {
			throw new NegocioException("Professor não informado");

		}
		Professor prof2 = prof1.findById(curso.getProf().getId())
				.orElseThrow(()->new NegocioException("Professor não encontrado"));


		curso.setProf(prof2);
		curso.setStatus(StatusCurso.ABERTA);
		 
		return CursoRes.save(curso);
		
	}

	@Override
	public Curso atualizarCurso(Long cursoId, Curso curso) {
		
		if (!CursoRes.existsById(cursoId)) {
			throw new NegocioException("Curso inexistente");
		}
		Professor prof = prof1.findById(curso.getProf().getId())
			.orElseThrow(()-> new NegocioException("Professor não encontrado "));
		
		curso.setId(cursoId);
		curso=CursoRes.save(curso);

		return curso;
	}

	@Override
	public Curso excluirCurso(Long cursoId) {
		var curso = buscarCursoPorId(cursoId);
		
		if (!CursoRes.existsById(cursoId)) {
		return null;
		}
		
		CursoRes.deleteById(cursoId);
		return curso;
	}

	@Override
	public List<Curso> buscarCursos() {
		return CursoRes.findAll();
	}

	@Override
	public Curso buscarCursoPorId(Long cursoId) {
		java.util.Optional<Curso> curso = CursoRes.findById(cursoId);

		if (curso.isPresent()) {
			return curso.get();
		}
		
		return null;
	}

	@Override
	public Boolean existeCursoPorId(Long cursoId) {

		if (!CursoRes.existsById(cursoId)) {
			return false;
		}

		return true;
	}
	
	

}
