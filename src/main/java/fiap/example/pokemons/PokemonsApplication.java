package fiap.example.pokemons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PokemonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonsApplication.class, args);
	}

	@RestController
	public class HealthController {

		@GetMapping("/health")
		public String health() {
			return "API OK";
		}
	}
}
