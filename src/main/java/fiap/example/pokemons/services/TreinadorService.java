package fiap.example.pokemons.services;

import fiap.example.pokemons.dto.TreinadorDTO;
import fiap.example.pokemons.models.Treinador;
import fiap.example.pokemons.repository.TreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TreinadorService {

    @Autowired
    private TreinadorRepository repository;

    // GET ALL
    public List<Treinador> getTreinadores() {
        return repository.findAll();
    }

    // GET BY ID
    public Optional<Treinador> getTreinadorById(Long id) {
        return repository.findById(id);
    }

    // POST
    public Treinador addTreinador(Treinador treinador) {
        return repository.save(treinador);
    }

    // PUT
    public Treinador updateTreinador(Long id, Treinador novo) {

        var optional = getTreinadorById(id);
        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TREINADOR NÃO ENCONTRADO");
        }

        novo.setId(id);
        return repository.save(novo);
    }

    // DELETE
    public void deleteTreinador(Long id) {
        var optional = getTreinadorById(id);

        if (optional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TREINADOR NÃO ENCONTRADO");
        }

        repository.deleteById(id);
    }

    // ENTITY -> DTO
    public TreinadorDTO toDTO(Treinador t) {

        TreinadorDTO dto = new TreinadorDTO();

        dto.setId(t.getId());
        dto.setNome(t.getNome());
        dto.setEmail(t.getEmail());
        dto.setIdade(t.getIdade());
        dto.setAtivo(t.getAtivo());

        return dto;
    }
}