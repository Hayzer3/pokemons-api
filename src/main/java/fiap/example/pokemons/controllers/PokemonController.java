package fiap.example.pokemons.controllers;

import fiap.example.pokemons.models.Pokemon;
import fiap.example.pokemons.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    @Autowired
    private PokemonService service;

    @GetMapping
    public List<Pokemon> getPokemons() {
        return service.getPokemons();
    }

    @PostMapping
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        return service.addPokemon(pokemon);
    }

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable Long id) {
        return service.getPokemonById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Long id) {
        service.deletePokemon(id);
    }

    @PutMapping("/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return service.updatePokemon(id, pokemon);
    }
}