package Projeto.implemento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Projeto.modelo.Professor;
import Projeto.repository.ProfessorRepository;
import Projeto.service.ProfessorService;
import domainException.NegocioException;
import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	@Autowired
	private ProfessorRepository profad;
	
	@Override
	public Professor addProf(Professor prof) {
		Professor profexiste=profad.findByEmail(prof.getEmail());
		
		if (profexiste!=null&&!profexiste.equals(prof)) {
			throw new NegocioException("Ja existe um professor com esse email");
		}
		return profad.save(prof);
	}

	@Override
	public Professor atualizaProf(Long id, Professor prof) {
		if (!profad.existsById(id)) {
		return null;
	}
	prof.setId(id);	
	prof=profad.save(prof);
	return prof;
	}

	@Override
	public Professor removeProf(Long id) {
		var prof = buscarProfessorPorId(id);
		
		if (!profad.existsById(id)) {
			return null;
		}
		profad.deleteById(id);
		return prof;
	}

	@Override
	public List<Professor> buscarProf() {
		return profad.findAll();

	}

	@Override
	public Professor buscarProfessorPorId(Long profId) {
	java.util.Optional<Professor> prof=profad.findById(profId);
		
		if (prof.isPresent()) {
			return prof.get();
		}
		return null;
	}

		
	@Override
	public Boolean existeProfessorPorId(Long profId) {
		if (!profad.existsById(profId)) {
			return false;
		}
		return true;
	}

	@Override
	public Professor findByEmail(String email) {

		Professor prof=profad.findByEmail(email);

		if (prof!=null) {
			return prof;
		}
		
		return null;
	}
		

	


}
