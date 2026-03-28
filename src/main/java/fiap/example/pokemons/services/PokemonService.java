package fiap.example.pokemons.services;

import fiap.example.pokemons.dto.PokemonDTO;
import fiap.example.pokemons.models.Pokemon;
import fiap.example.pokemons.models.Treinador;
import fiap.example.pokemons.repository.PokemonRepository;
import fiap.example.pokemons.repository.TreinadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    @Autowired
    private TreinadorRepository treinadorRepository;

    //  GET ALL
    public List<Pokemon> getPokemons() {
        return repository.findAll();
    }

    // GET BY ID
    public Optional<Pokemon> getPokemonById(Long id) {
        return repository.findById(id);
    }

    //  POST
    public Pokemon addPokemon(Pokemon pokemon) {

        //  buscar treinador no banco
        if (pokemon.getTreinador() != null) {
            Long idTreinador = pokemon.getTreinador().getId();

            Treinador treinador = treinadorRepository.findById(idTreinador)
                    .orElseThrow(() -> new RuntimeException("Treinador não encontrado"));

            pokemon.setTreinador(treinador);
        }

        return repository.save(pokemon);
    }

    //  PUT
    public Pokemon updatePokemon(Long id, Pokemon novo) {

        var optional = getPokemonById(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "POKEMON NÃO ENCONTRADO");
        }

        //  buscar treinador no banco também no update
        if (novo.getTreinador() != null) {
            Long idTreinador = novo.getTreinador().getId();

            Treinador treinador = treinadorRepository.findById(idTreinador)
                    .orElseThrow(() -> new RuntimeException("Treinador não encontrado"));

            novo.setTreinador(treinador);
        }

        novo.setId(id);
        return repository.save(novo);
    }

    //  DELETE
    public void deletePokemon(Long id) {
        var optional = getPokemonById(id);

        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "POKEMON NÃO ENCONTRADO");
        }

        repository.deleteById(id);
    }

    // ENTITY → DTO
    public PokemonDTO toDTO(Pokemon p) {

        PokemonDTO dto = new PokemonDTO();

        dto.setId(p.getId());
        dto.setNome(p.getNome());
        dto.setNivel(p.getNivel());
        dto.setHp(p.getHp());
        dto.setAtaque(p.getAtaque());
        dto.setDefesa(p.getDefesa());
        dto.setFavorito(p.getFavorito());

        if (p.getTipo() != null) {
            dto.setTipo(p.getTipo().name());
        }

        return dto;
    }
}