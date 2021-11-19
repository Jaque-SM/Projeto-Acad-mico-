package Projeto.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Projeto.modelo.Aluno;
import Projeto.repository.AlunoRepository;
import Projeto.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoControler {
	
	@Autowired
	private AlunoRepository aluno;
	
	@GetMapping
	public List <Aluno> listar(){
		return aluno.findAll();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Aluno adicionar(@Valid  @RequestBody Aluno aln) {
		return aluno.save(aln);
	}
	
	@DeleteMapping("/{alunoId}")
	public ResponseEntity<Void> remover(@PathVariable Long alunoId) {
		if (!aluno.existsById(alunoId)) {
			return ResponseEntity.notFound().build();

		}
		aluno.deleteById(alunoId);
		return ResponseEntity.noContent().build();

	}
	@PutMapping("/{alunoId}")
	public ResponseEntity<Aluno> atualizar(@Valid @PathVariable Long alunoId, @RequestBody Aluno aln) { 
		
		if (!aluno.existsById(alunoId)) {
			return ResponseEntity.notFound().build();

		}
		aln.setId(alunoId);
		aln=aluno.save(aln);
		
		return ResponseEntity.ok(aln);
	}
	@RequestMapping(value = "/{alunoId}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscar(@PathVariable Long alunoId) { 
		Optional<Aluno> aln = aluno.findById(alunoId);
		
		if (aln.isPresent()) {
			return ResponseEntity.ok(aln.get());
		}
		return ResponseEntity.notFound().build();

	}
	
}
