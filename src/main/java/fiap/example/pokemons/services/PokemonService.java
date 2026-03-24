package fiap.example.pokemons.services;

import fiap.example.pokemons.models.Pokemon;
import fiap.example.pokemons.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository repository;

    public List<Pokemon> getPokemons() { return repository.findAll(); }

    public Pokemon addPokemon(Pokemon pokemon) { return repository.save(pokemon); }

    public Optional<Pokemon> getPokemonById(Long id) {return repository.findById(id); }

    public void deletePokemon(Long id){
        var optionalPokemon = getPokemonById(id);
        if (optionalPokemon.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "POKEMON NÃO ENCOTRADO");
        }
            repository.deleteById(id);
        }

        public Pokemon updatePokemon (Long id, Pokemon newPokemon){
            var optionalPokemon = getPokemonById(id);
            if (optionalPokemon.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "POKEMON não encontrado");

            }
            newPokemon.setId(id);
            return repository.save(newPokemon);

        }
    }
