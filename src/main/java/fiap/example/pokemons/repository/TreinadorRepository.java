package fiap.example.pokemons.repository;

import fiap.example.pokemons.models.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinadorRepository extends JpaRepository<Treinador, Long> {
}
