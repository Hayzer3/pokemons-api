package fiap.example.pokemons.dto;

import lombok.Data;

@Data
public class PokemonDTO {

    private Long id;
    private String nome;
    private Integer nivel;
    private Integer hp;
    private Integer ataque;
    private Integer defesa;
    private Boolean favorito;
    private String tipo;
}
