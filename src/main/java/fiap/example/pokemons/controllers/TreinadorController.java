package fiap.example.pokemons.controllers;

import fiap.example.pokemons.dto.TreinadorDTO;
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

    // GET ALL
    @GetMapping
    public List<TreinadorDTO> getTreinadores() {
        return service.getTreinadores()
                .stream()
                .map(service::toDTO)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TreinadorDTO getTreinadorById(@PathVariable Long id) {
        return service.getTreinadorById(id)
                .map(service::toDTO)
                .orElseThrow(() -> new RuntimeException("TREINADOR NÃO ENCONTRADO"));
    }

    // POST
    @PostMapping
    public Treinador addTreinador(@RequestBody Treinador treinador) {
        return service.addTreinador(treinador);
    }

    // PUT
    @PutMapping("/{id}")
    public Treinador updateTreinador(@PathVariable Long id, @RequestBody Treinador treinador) {
        return service.updateTreinador(id, treinador);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteTreinador(@PathVariable Long id) {
        service.deleteTreinador(id);
    }
}