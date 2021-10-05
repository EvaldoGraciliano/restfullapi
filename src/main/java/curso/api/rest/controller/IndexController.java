package curso.api.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // Arquitetura
@RequestMapping (value = "/usuario")
public class IndexController {
	
	
	// serviço restfull 
	@GetMapping (value = "/", produces = "application/json")
	public ResponseEntity init (@RequestParam (value = "nome", defaultValue = "João nome default") String nome ) {
		System.out.println("Parametro Sendo recebido: " + nome);
		return new ResponseEntity("Olá REST Spring Boot seu nome é: " + nome, HttpStatus.OK);
		
	}
	
	
}
