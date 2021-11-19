package Projeto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import Projeto.service.Validar;
import Projeto.service.Validar.ProfessorId;

@Entity
@Table(name="Professor")
public class Professor {
	
	@NotNull(groups = Validar.ProfessorId.class)
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column
	@NotBlank
	@Size(max = 30)
	private String nome_Professor;
	@Column
	@NotBlank
	@Size(max = 30)
	private String titulacao;
	@Column
	@NotBlank
	@Size(max = 30)
	private String email;
	@Column
	@NotBlank
	@Size(max = 30)
	private String telefone;
	
	public Professor() {
		super();
	}

	public Professor(@NotNull(groups = ProfessorId.class) Long id, @NotBlank @Size(max = 30) String nome,
			@NotBlank @Size(max = 30) String titulacao, @NotBlank @Size(max = 150) String email,
			@NotBlank @Size(max = 20) String telefone) {
		super();
		this.id = id;
		this.nome_Professor = nome;
		this.titulacao = titulacao;
		this.email = email;
		this.telefone = telefone;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_Professor() {
		return nome_Professor;
	}
	public void setNome_Professor(String nome_Professor) {
		this.nome_Professor = nome_Professor;
	}
	public String getTitulacao() {
		return titulacao;
	}
	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome_Professor == null) ? 0 : nome_Professor.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((titulacao == null) ? 0 : titulacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome_Professor == null) {
			if (other.nome_Professor != null)
				return false;
		} else if (!nome_Professor.equals(other.nome_Professor))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (titulacao == null) {
			if (other.titulacao != null)
				return false;
		} else if (!titulacao.equals(other.titulacao))
			return false;
		return true;
	}
}