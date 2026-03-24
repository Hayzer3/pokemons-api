package fiap.example.pokemons.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ManyToAny;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Time {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn
    private Treinador treinador;

    @ManyToMany
    @JoinTable(
            name = "tb_time_pokemon",
            joinColumns = @JoinColumn(name = "id_time"),
            inverseJoinColumns = @JoinColumn(name = "id_pokemon")
    )

    private List<Pokemon> pokemons;

}
