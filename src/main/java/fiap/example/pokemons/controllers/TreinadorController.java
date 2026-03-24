package fiap.example.pokemons.controllers;

import fiap.example.pokemons.models.Treinador;
import fiap.example.pokemons.services.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinadores")
public class TreinadorController {

    @Autowired
    private TreinadorService service;

    @GetMapping
    public List<Treinador> getTreinadores() {
        return service.getTreinadores();
    }

    @PostMapping
    public Treinador addTreinador(@RequestBody Treinador treinador) {
        return service.addTreinador(treinador);
    }

    @GetMapping("/{id}")
    public Treinador getTreinadorById(@PathVariable Long id) {
        return service.getTreinadorById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteTreinador(@PathVariable Long id) {
        service.deleteTreinador(id);
    }

    @PutMapping("/{id}")
    public Treinador updateTreinador(@PathVariable Long id, @RequestBody Treinador treinador) {
        return service.updateTreinador(id, treinador);
    }
}