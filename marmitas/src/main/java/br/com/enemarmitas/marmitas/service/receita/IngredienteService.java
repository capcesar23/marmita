package br.com.enemarmitas.marmitas.service.receita;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.enemarmitas.marmitas.model.receita.Ingrediente;
import br.com.enemarmitas.marmitas.repository.receita.IngredienteRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IngredienteService {

    private IngredienteRepository ingredienteRepository;

    public Optional<Ingrediente> getIngredienteById(Long ingredienteId) {
        if (ingredienteId == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        return ingredienteRepository.findById(ingredienteId);
    }

    public List<Ingrediente> buscarByNome(String nome) {
        return ingredienteRepository.findByNomeContainingIgnoreCase(nome);
    }

    public List<Ingrediente> getAllIngredientes() {
        return ingredienteRepository.findAll();
    }

    public List<Ingrediente> findByFichaTecnicaId(Long fichatecnica) {
        return ingredienteRepository.findByFichaTecnicaId(fichatecnica);
    }

    /**public void deleteAllIngrediente() {
        ingredienteRepository.findAll();
    }
*/

    public Ingrediente updateIngrediente(Ingrediente ingrediente) {
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente não pode ser nulo");
        }
        return ingredienteRepository.save(ingrediente);
    }

    public Ingrediente insertIngrediente(Ingrediente ingrediente) {
        if (ingrediente == null) {
            throw new IllegalArgumentException("Ingrediente não pode ser nulo");
        }
        return ingredienteRepository.save(ingrediente);
    }


    public boolean deleteIngredienteById(Long ingredienteId) {
        if (ingredienteId== null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }
        ingredienteRepository.deleteById(ingredienteId);
        return true;
    }


}
