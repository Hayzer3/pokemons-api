package fiap.example.pokemons.controllers;

import fiap.example.pokemons.dto.TimeDTO;
import fiap.example.pokemons.models.Time;
import fiap.example.pokemons.services.TimeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService service;

    // GET ALL
    @GetMapping
    public List<TimeDTO> getTimes() {
        return service.getTimes()
                .stream()
                .map(service::toDTO)
                .toList();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public TimeDTO getTimeById(@PathVariable Long id) {
        return service.getTimeById(id)
                .map(service::toDTO)
                .orElseThrow(() -> new RuntimeException("TIME NÃO ENCONTRADO"));
    }

    // POST
    @PostMapping
    public Time addTime(@RequestBody Time time) {
        return service.addTime(time);
    }

    // PUT
    @PutMapping("/{id}")
    public Time updateTime(@PathVariable Long id, @RequestBody Time time) {
        return service.updateTime(id, time);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteTime(@PathVariable Long id) {
        service.deleteTime(id);
    }
}