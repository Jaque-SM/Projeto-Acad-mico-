package Projeto.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;


@Entity
@Table(name="Turma")
public class Turma {

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column
	private String turno;
	
	@NotBlank
	@Column
	private String datainicio;
	
	@NotBlank
	@Column
	private String datafim;
	
	@NotBlank
	@Column
	private String horario;
	
	@NotNull
	@Column
	private int qtdvagas;
	

	@NotNull
	@Valid
	@ManyToOne
	private Aluno aluno;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getDataInicio() {
		return datainicio;
	}

	public void setDataInicio(String dataInicio) {
		this.datainicio = dataInicio;
	}

	public String getDataFim() {
		return datafim;
	}

	public void setDataFim(String dataFim) {
		this.datafim = dataFim;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public int getQtdVagas() {
		return qtdvagas;
	}

	public void setQtdVagas(int qtdVagas) {
		this.qtdvagas = qtdVagas;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno=aluno;
	}
	public Long Aluno() {
		
		return aluno.getId();
	}


	
	
	
	
	
}
