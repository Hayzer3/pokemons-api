package fiap.example.pokemons.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Pokemon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer nivel;
    private Integer hp;
    private Integer ataque;
    private Integer defesa;
    private Boolean favorito;
    private LocalDate dataCaptura;

    @Enumerated(EnumType.STRING)
    private TipoPokemon tipo;

    @ManyToOne
    @JoinColumn(name = "treinador_id")
    @JsonBackReference
    private Treinador treinador;


}
