package curso.api.rest.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import curso.api.rest.model.Usuario;
import curso.api.rest.repository.UsuarioRepository;

@RestController // Arquitetura
@RequestMapping (value = "/usuario")

public class IndexController {
	
	@Autowired // se fosse CDI seria @Inject, mas aqui é Spring o/
	private UsuarioRepository usuarioRepository;
	
	/* Rota diferente GET */
	@GetMapping (value = "/{id}/relatoriopdf", produces = "application/json")
	public ResponseEntity<Usuario> relatorio (@PathVariable (value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		/* o retorno seria um relatório */
		return new ResponseEntity<Usuario>(usuario.get(),HttpStatus.OK);
	}
	
	
	/* serviço restfull, retornando pelo id GET */ 
	@GetMapping (value = "/{id}", produces = "application/json")
	
	public ResponseEntity<Usuario> init (@PathVariable (value = "id") Long id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		return new ResponseEntity<Usuario>(usuario.get(),HttpStatus.OK);
	}
	
	
	/* Método GET, retornando toda lista */
	
	@GetMapping ( value="/", produces = "application/json")
	public ResponseEntity<List<Usuario>> usuario(){
		
		List<Usuario> list = (List<Usuario>) usuarioRepository.findAll();
		return new ResponseEntity<List<Usuario>>(list, HttpStatus.OK);
	}
	
	/* Realizando Cadastro de usuário com Método POST" */
	
	@PostMapping (value = "/", produces = "application/json")
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
		
	}
	
	
	/* Editando usuário existente */
	@PutMapping (value = "/", produces = "application/json")
	public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
		
		/* outras rotinas antes de atualizar */
		
		Usuario usuarioSalvo = usuarioRepository.save(usuario);
		
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
}
	
	/* fazendo atualização usando valores passados direto na URL */
	
	@PutMapping (value = "/{iduser}/idvenda/{idvenda}", produces = "application/json")
	public ResponseEntity updateVenda(@PathVariable Long iduser, @PathVariable Long idvenda) {
		
		return new ResponseEntity("Venda atual", HttpStatus.OK);
	}
	
	
	/* deletando usuário pelo ID */
	@DeleteMapping (value = "/{id}", produces = "application/text")
	public ResponseEntity delete(@PathVariable ("id") Long id ) {
		
		usuarioRepository.deleteById(id);
		
		  return new ResponseEntity ("Usuario deletado", HttpStatus.OK);
		
		  // return "ok", precisaria mudar o recebimento do método também 
}
	
}
