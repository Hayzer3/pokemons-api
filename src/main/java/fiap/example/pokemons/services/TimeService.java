package fiap.example.pokemons.services;

import fiap.example.pokemons.models.Time;
import fiap.example.pokemons.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService {

    @Autowired
    private TimeRepository repository;

    public List<Time> getTimes() {
        return repository.findAll();
    }

    public Time addTime(Time time) {

        if (time.getPokemons() != null && time.getPokemons().size() > 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O TIME PODE TER NO MÁXIMO 6 POKÉMONS");
        }

        return repository.save(time);
    }

    public Optional<Time> getTimeById(Long id) {
        return repository.findById(id);
    }

    public void deleteTime(Long id) {
        var optional = getTimeById(id);

        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TIME NÃO ENCONTRADO");
        }

        repository.deleteById(id);
    }

    public Time updateTime(Long id, Time novo) {
        var optional = getTimeById(id);

        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TIME NÃO ENCONTRADO");
        }

        // regra de 6 também no update
        if (novo.getPokemons() != null && novo.getPokemons().size() > 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O TIME PODE TER NO MÁXIMO 6 POKÉMONS");
        }

        novo.setId(id);
        return repository.save(novo);
    }
}