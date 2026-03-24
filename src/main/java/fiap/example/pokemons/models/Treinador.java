package fiap.example.pokemons.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Treinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    private Integer idade;
    private Boolean ativo;

    private LocalDate dataCadastro;

    @OneToMany(mappedBy = "treinador")
    @JsonManagedReference
    @JsonIgnore
    private List<Pokemon> pokemons;
}