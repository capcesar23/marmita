package br.com.enemarmitas.marmitas.service.receita;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.enemarmitas.marmitas.model.receita.FichaTecnica;
import br.com.enemarmitas.marmitas.repository.receita.FichaTecnicaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FichaTecnicaService {

    private FichaTecnicaRepository fichaTecnicaRepository;

    
    public Optional<FichaTecnica> getFichaTecnicaById(Long fichaTecnicaId) {
        if (fichaTecnicaId== null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        return fichaTecnicaRepository.findById(fichaTecnicaId);
    }

    public List<FichaTecnica> buscarByNome(String nome) {
    return fichaTecnicaRepository.findByNomeContainingIgnoreCase(nome);
}
  
    public List<FichaTecnica> getAllFichasTecnicas() {
        return fichaTecnicaRepository.findAll();
    }

     public void deleteAllFichasTecnicas() {
        fichaTecnicaRepository.deleteAll();
    }


    public boolean deleteFichaTecnicaById(Long fichaTecnicaId) {
        if (fichaTecnicaId == null) {
            throw new IllegalArgumentException("ID não pode ser nulo");
        }

        fichaTecnicaRepository.deleteById(fichaTecnicaId);
        return true;
    }

  
    public FichaTecnica updateFichaTecnica(FichaTecnica fichaTecnica) {
        if (fichaTecnica == null) {
            throw new IllegalArgumentException("FichaTecnica não pode ser nulo");
        }

        return fichaTecnicaRepository.save(fichaTecnica);
    }

   
    public FichaTecnica insertFichaTecnica(FichaTecnica fichaTecnica) {
        if (fichaTecnica == null) {
            throw new IllegalArgumentException("FichaTecnica não pode ser nulo");
        }

        return fichaTecnicaRepository.save(fichaTecnica);
    }
}
