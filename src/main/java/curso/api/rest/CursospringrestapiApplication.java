package curso.api.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EntityScan(basePackages = {"curso.api.rest.model"}) // lê todas as classes do pacote e cria as tabelas automáticas
@ComponentScan ({"curso.*"}) // Injeção de dependência, spring controla todos os objetos
@EnableJpaRepositories(basePackages = {"curso.api.rest.repository"}) // 
@EnableTransactionManagement // controlar as transações no banco de dados 
@EnableWebMvc 
@RestController
@EnableAutoConfiguration
public class CursospringrestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursospringrestapiApplication.class, args);
	}

}
