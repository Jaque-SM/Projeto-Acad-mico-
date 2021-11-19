package Projeto.controler;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

import Projeto.modelo.Professor;
import Projeto.service.ProfessorService;


@RestController
@RequestMapping("/professores")
public class ProfessorControler {
	
	@Autowired
	private ProfessorService adprof;
	
	@GetMapping
	public List <Professor> listar(){
		return adprof.buscarProf();
		
	}
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public Professor adicionar (@Validated  @RequestBody Professor prof) {
		return adprof.addProf(prof);
	}
	
	@DeleteMapping("/{profId}")
	public ResponseEntity<Void> remover(@PathVariable Long profId) {
		
		if (!adprof.existeProfessorPorId(profId)) {
			return ResponseEntity.notFound().build();
	}
		adprof.removeProf(profId);
		return ResponseEntity.noContent().build();
	}
		

	@PutMapping("/{profId}")
	public ResponseEntity<Professor> atualizar(@Validated @PathVariable Long profId, @RequestBody Professor prof) { 
	
		if (!adprof.existeProfessorPorId(profId)) {
			return ResponseEntity.notFound().build();
		}
		Professor profnovo=adprof.atualizaProf(profId, prof);
		
		return ResponseEntity.ok(profnovo);
		}
	
	@RequestMapping(value = "/{profId}", method = RequestMethod.GET)
	public ResponseEntity<Professor> buscar(@PathVariable Long profId) { 
		
		if (!adprof.existeProfessorPorId(profId)) {
			return ResponseEntity.notFound().build();
			}
		Professor profresult=adprof.buscarProfessorPorId(profId);
		return ResponseEntity.ok(profresult);
		
	}
}
	

