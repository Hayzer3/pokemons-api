package fiap.example.pokemons.dto;

import lombok.Data;

@Data
public class TreinadorDTO {
    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private Boolean ativo;
}
