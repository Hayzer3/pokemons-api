package fiap.example.pokemons.repository;

import fiap.example.pokemons.models.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
