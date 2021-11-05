package br.org.serratec.backend.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(EmailException.class)
	
	public ResponseEntity<Object> handleEmailException(EmailException ex){   //pode ser protected
		EmailException emailException = new EmailException(ex.getMessage());
		return ResponseEntity.unprocessableEntity().body(emailException);
	}
	//unprocessableEntity - retorna o erro 422 - erro do usuario quando digita algo que já existe
	//body(emailException) - joga a mensagem de erro lá
	
}
