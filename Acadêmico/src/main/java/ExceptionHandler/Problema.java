package ExceptionHandler;

import java.time.OffsetDateTime;

public class Problema {
	
	private int status;
	private String titulo;
	private OffsetDateTime datahora;
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int i) {
		this.status = i;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public OffsetDateTime getData() {
		return datahora;
	}
	public void setData(OffsetDateTime data) {
		this.datahora = data;
	}
	
	
	
}