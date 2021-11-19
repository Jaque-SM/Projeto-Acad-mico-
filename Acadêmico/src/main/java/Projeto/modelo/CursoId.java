package Projeto.modelo;

import javax.validation.constraints.NotBlank;

public class CursoId {
	
	
	@NotBlank
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
