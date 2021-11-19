package domainException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.OffsetDateTime;

import ExceptionHandler.Problema;

@ControllerAdvice
public class Exception extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){
		var status=HttpStatus.BAD_REQUEST;
		
		var problema=new Problema();
		
		problema.setStatus(status.value());
		problema.setTitulo(ex.getMessage());
		problema.setData(OffsetDateTime.now());
		
		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
		
	}
	
}