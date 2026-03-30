package fiap.example.pokemons.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TimeDTO {
    private Long id;
    private String nome;
    private LocalDate dataCriacao;
    private TreinadorDTO treinador;
    private List<PokemonDTO> pokemons;
}
