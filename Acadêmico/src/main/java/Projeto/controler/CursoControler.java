package Projeto.controler;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import Projeto.modelo.Curso;
import Projeto.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoControler {
	
	@Autowired
	private CursoService cursoSe;

	@GetMapping
	public List<Curso> buscarCursos() {
		return cursoSe.buscarCursos();
	}
		
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public Curso adicionar (@Valid  @RequestBody Curso cd) {
		return cursoSe.inserirCurso(cd);
	}
		
	@PutMapping("/{cursoId}") 
	public ResponseEntity<Curso> atualizar(@Valid @PathVariable Long cursoId, @RequestBody Curso curso) { 
	
		if (!cursoSe.existeCursoPorId(cursoId)) {
			return ResponseEntity.notFound().build();
		}
		Curso novo=cursoSe.atualizarCurso(cursoId, curso);
		
		return ResponseEntity.ok(novo);
		
	}
	@GetMapping("/{cursoId}")
	public ResponseEntity<Curso> buscar(@PathVariable Long cursoId) { 
		
		if (!cursoSe.existeCursoPorId(cursoId)) {
			return ResponseEntity.notFound().build();

		}
		Curso procura=cursoSe.buscarCursoPorId(cursoId);
		return ResponseEntity.ok(procura);
	}

	@DeleteMapping("/{cursoId}")
	public ResponseEntity<Void> remover(@PathVariable Long cursoId) {
		
		if (!cursoSe.existeCursoPorId(cursoId)) {
			return ResponseEntity.notFound().build();
		}
		cursoSe.excluirCurso(cursoId);
		
		return ResponseEntity.noContent().build();
		
	}
	

}
