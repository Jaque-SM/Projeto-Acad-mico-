package Projeto.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Projeto.modelo.Turma;
import Projeto.repository.TurmaRepository;
import Projeto.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaControler {
	
	@Autowired
	private TurmaService turma;
	
	@GetMapping
	public List <Turma> buscarTurmas(){
		return turma.buscarTurma();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Turma  inserirTurma(@Valid @RequestBody Turma tm) {
		return turma.adicionarTurma(tm);
		
	}
	
	@PutMapping("/{Id}")
	public ResponseEntity<Turma> atualizar(@Valid @PathVariable Long Id, 
			@RequestBody Turma tm){
		 if (!turma.existeTurmaPorId(Id)) {
			 return ResponseEntity.notFound().build();

		 }
		 Turma mat=turma.atualizaTurma(Id, tm);

		 return ResponseEntity.ok(mat);
	}
	@DeleteMapping("/{Id}")
	public ResponseEntity<Void> remover(@PathVariable Long Id) {
		 if (!turma.existeTurmaPorId(Id)) {
			 return ResponseEntity.notFound().build();

		 }
		 turma.removeTurma(Id);
		 return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Turma> buscar(@PathVariable Long Id) { 
		 
		if (!turma.existeTurmaPorId(Id)) {
			 return ResponseEntity.notFound().build();
	}
	
		Turma mat=turma.buscarPorID(Id);
		return ResponseEntity.ok(mat);
	
	}
		

	

}
