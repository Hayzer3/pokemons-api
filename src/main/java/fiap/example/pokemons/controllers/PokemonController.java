package fiap.example.pokemons.controllers;

import fiap.example.pokemons.dto.PokemonDTO;
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

    // GET ALL
    @GetMapping
    public List<PokemonDTO> getPokemons() {
        return service.getPokemons()
                .stream()
                .map(service::toDTO)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public PokemonDTO getPokemonById(@PathVariable Long id) {
        return service.getPokemonById(id)
                .map(service::toDTO)
                .orElseThrow(() -> new RuntimeException("POKEMON NÃO ENCONTRADO"));
    }

    // POST (entity)
    @PostMapping
    public Pokemon addPokemon(@RequestBody Pokemon pokemon) {
        return service.addPokemon(pokemon);
    }

    // PUT
    @PutMapping("/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {
        return service.updatePokemon(id, pokemon);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deletePokemon(@PathVariable Long id) {
        service.deletePokemon(id);
    }
}